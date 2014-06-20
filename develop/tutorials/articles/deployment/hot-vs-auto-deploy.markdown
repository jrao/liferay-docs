# Hot Deploy vs. Auto Deploy 

This tutorial provides an overview of how Liferay uses the hot deployment
mechanisms of many Java EE application servers. It also explains Liferay's auto
deployment mechanism. It's easy to confuse an application server's hot
deployment mechanism with Liferay's auto-deployment mechanism. Don't make the
mistake of assuming that these two mechanisms are synonomous! They're not. We'll
start by explaining what hot deployment means then we'll explore Liferay's
auto-deployment mechanism.

## Using Hot Deployment 

You might have heard the term *hot deployment* used in the context of Java EE
application servers. In summary, you place an application artifact (WAR or EAR)
file into a specifically configured directory and your application server
(Tomcat, WebSphere, WebLogic, etc.) picks up that artifact, deploys it within
the application server, and starts the application.

This model works very well for development purposes, since a server restart is
not required to view updates from your code changes. This model also works for
single node production deployments. 

However, this model completely breaks down when you deploy to a multi-node 
production deployment. In a multi-node environment, you have many more 
constraints to deal with, that require you to: 

- Ensure the application archive is available to all nodes
- Ensure the application deploys successfully across all nodes, simultaneously

Most application servers solve these constraints by using a master/slave type of
design: an admin server with multiple managed servers. When you hot deploy a
plugin, you use the admin server's user interface, or vendor console tool like
[Wsadmin](http://en.wikipedia.org/wiki/Wsadmin), to add the archive, select
which managed servers should deploy it, and start the application. Application
server vendors often have different names and tools for these modes and tools:

- JBoss "domain" mode
- WebLogic "production" mode
- WebSphere deployment manager
- Tomcat FarmWarDeployer

These modes and tools reside completely outside of Liferay Portal and are
strictly in the application server's realm. However, Liferay piggybacks off the
application server's hot deploy capability and performs additional
initialization after a given application starts (e.g., via
`javax.servlet.ServletContextListener` mechanisms). 

<!-- "This is considered more as an application lifecycle and inter-application
dependency management as opposed to hot deploy. When Liferay moves fully to OSGi
in 7.0, we will more cleanly separate "hot deploy" and "application lifecycle"
concepts." We should keep these statements by Mike Han in mind for 7.0.-->

There are some specific Liferay capabilities that won't work unless your
application server has hot deployment capabilities. Specifically, hot deploying
custom JSPs in hooks won't work, because Liferay's JSP hook overriding
capabilities depend on the application server's ability to:

- Deploy based on an exploded portal WAR
- Load changes to JSP files at runtime

Application servers running in "production" and "domain" modes cannot support
these abilities, because in these deployment models, most servers don't use
exploded WARs. As such, these application servers don't support JSP
reloading/recompilation in these modes. Even for Tomcat, it's generally
advisable to deactivate JSP reloading for production deployments. 

So what do you do if you use hooks to override Liferay JSPs AND you must use
non-exploded WAR deployments? The answer is simple: inject a pre-processing
stage as part of your build process. You deploy the hooks, allowing them to make
changes to the portal WAR file. Then you rebundle the portal WAR file and deploy
it using the application server's deployment tools. Of course, you still need to
deploy your hook as well, but you no longer need to worry about the JSP
overrides not being loaded by your application server.

Hopefully this whets your appetite for using hot deployment. Stay hungry; we'll
explore auto deployment next. 

## Using Auto Deployment 

The Liferay *auto* deployment feature is a mostly optional feature that works in
conjunction with the hot deployment capabilities of your application server.
Whereas Liferay's hot deploymentment mechanism leverages the hot deploy
capabilities of your app server and performs additional initializations, auto
deployment injects the required JAR files and descriptors into your
application's archive file.  Executing `ant deploy` invokes both hot deployment
and auto deployment tasks for your plugin. 

So how does auto deployment work with Liferay plugins? Auto deployment completes
the following tasks:

1. Picks up a Liferay recognized archive (e.g., `*-portlet.*`, `*-theme.*`,
   `*-web.*`, `*.lpkg`)
2. Injects required libraries (e.g., `util-java.jar`, `util-taglib.jar`)
3. Injects dependent JAR files (specified in `liferay-plugins.properties`)
4. Injects required taglib descriptors (e.g., `liferay-theme.tld`)
5. Injects required deployment descriptors (e.g., app server specific
   descriptors)
6. Injects any missing Liferay specific deployment descriptors (e.g.,
   `liferay-portlet.xml`)

By relying on auto deployment to complete these tasks automatically, you save
time and you don't even have to learn all of Liferay's deployment descriptors.
However, this feature is incompatible with application server farms and
multi-node modes. 

So now you're probably wondering how to configure your application server in
these kinds of situations. The answer is simple: Do not use the auto deployment
method at runtime; use it at build time.

The Liferay Plugins SDK allows you to preprocess your archives and inject all
the required elements. You therefore bypass the auto deployer at runtime. You
simply need to call the following Ant task:

    ant direct-deploy

The `direct-deploy` Ant task creates an exploded WAR from which you can easily
create a WAR file. The location of the exploded WAR depends on the deployment
directory of the application server you've configured in your Plugins SDK
environment. See the *Plugins SDK Configuration* section of [Leveraging the Plugins SDK](http://www.liferay.com/documentation/liferay-portal/6.2/development/-/ai/leveraging-the-plugins-sdk-liferay-portal-6-2-dev-guide-02-en)
for instructions on configuring the Plugins SDK for your app server. The Plugins
SDK's `build.properties` provides a default deployment directory value for each
supported app server. But you can override the default value by specifying your
desired value for the `app.server.[type].deploy.dir` (replace `[type]` with your
app server type) in your `build.[username].properties` file. 

If you choose not to use the Liferay Plugins SDK to do direct deployment, you
can examine the `build-common.xml` file in the Plugins SDK to see how Liferay
invokes the deployer tools.

Terrific! You now know the differences between hot deploy and auto deploy.
Understanding what's going on during the deployment of your plugins is crucial
for troubleshooting anything that goes wrong. This knowledge can help you
simplify your deployment process and make it more efficient.
