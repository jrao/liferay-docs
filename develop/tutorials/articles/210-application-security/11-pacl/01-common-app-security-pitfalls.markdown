# Handling Security Exceptions

As you develop your @product@ app, you need to anticipate your app's actions in
light of @product@'s secured environment. Liferay's security manager leverages
the Java SE Security Architecture. Therefore, understanding Java SE Security
and learning the few requirements that Liferay's security manager adds on top
of it will benefit you as you develop apps. For information on Java SE's
Security Architecture, please refer
[here](http://docs.oracle.com/javase/7/docs/technotes/guides/security/spec/security-spec.doc.html).

Here's a common mistake made by developers that violates Liferay's secured
environment: 

- Invoking a method, directly or indirectly, without considering whether the
  method can throw a security exception.

You wouldn't intentionally make this kind of mistake, but it's easy to make if
you're not being careful.

When you're running on Liferay Portal with the security manager enabled for
your app, you must only access authorized resources. If you invoke a method
declared as throwing a security exception (i.e., `java.lang.SecurityException`)
and you're not authorized to access the resources used by a method, the method
throws the security exception and the security manger stops the offending
module dead in its tracks. Security exceptions are unchecked, meaning that the
compiler doesn't require your code to handle them. However, since methods that
throw security exceptions are declared as throwing them, you should check their
signatures while you're designing your app. If the methods used by your app
throw security exceptions, handle them appropriately with try/catch blocks.
Keep in mind that you must handle a method's security exception regardless of
whether your app invokes the method directly or indirectly. 

For example, suppose you're using a file utility that calls the `canRead`
method of `java.io.File`. Since the `canRead` method can throw a
`SecurityException`, your app will violate security if it invokes the utility
on a file that you're not authorized to access. Therefore, it's important that
you're aware of all the security exceptions thrown by methods that your app
invokes, regardless of whether it invokes the methods directly or indirectly. 

Operations involving reflection and similar activities can typically throw
security exceptions. The Java SE Security documentation explains how to deal
with them. In many cases, you can declare your app's permissions to avoid
running into these exceptions. Configuring your app's permissions and security
policies is covered in the tutorial 
[Building and Testing Your App's PACL](/develop/tutorials/-/knowledge_base/7-0/building-and-testing-your-apps-pacl). 

The bottom line is that you must be aware of the how the libraries you use
behave with respect to your secured environment. The better you understand Java
SE Security and Liferay's security management, the easier it is for you to
write security-aware apps. Keeping this in mind, you can now confidently
proceed to create Liferay apps! 

<!--
## Related Topics [](id=related-topics)

[Setting Permissions](/develop/tutorials/-/knowledge_base/6-2/setting-permissions)

[Developing with the Plugins SDK](/develop/tutorials/-/knowledge_base/6-2/plugins-sdk)

[Developing Plugins with Liferay IDE](/develop/tutorials/-/knowledge_base/6-2/liferay-ide)

[Developing with Maven](/develop/tutorials/-/knowledge_base/6-2/maven)

[MVC Portlets](/develop/tutorials/-/knowledge_base/6-2/developing-jsp-portlets-using-liferay-mvc)

[Liferay Faces](/develop/tutorials/-/knowledge_base/6-2/liferay-faces-jsf-portlets)
-->
