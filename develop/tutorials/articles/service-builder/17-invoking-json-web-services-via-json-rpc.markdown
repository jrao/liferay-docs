### JSON RPC [](id=json-rpc)

You can invoke JSON Web Service using [JSON RPC](http://json-rpc.org). Most of
the JSON RPC 2.0 specification is supported in Liferay JSON web services. One
important limitation is that parameters must be passed in as *named* parameters.
Positional parameters are not supported, as there are too many overloaded
methods for convenient use of positional parameters. 

Here's an example of invoking a JSON web service using JSON RPC: 

    POST http://localhost:8080/api/jsonws/dlapp
    {
        "method":"get-folders",
        "params":{"repositoryId":10172, "parentFolderId":0},
        "id":123,
        "jsonrpc":"2.0"
    }

Let's talk about parameters that are made available to secure JSON web
services by default. 

### Default Parameters [](id=default-parameters)

When accessing *secure* JSON web services (i.e., the user has to be
authenticated), some parameters are made available to the web services by
default. Unless you want to change their values to something other than their
defaults, you don't have to specify them explicitly. 

Here are the default parameters:

- `userId`: The id of authenticated user
- `user`: The full User object
- `companyId`: The users company
- `serviceContext`: The empty service context object 

Let's find out about object parameters next. 

### Object Parameters [](id=object-parameters)

Most services accept simple parameters like numbers and strings. However,
sometimes you might need to provide an object (a non-simple type) as a service
parameter. 

To create an instance of an object parameter, prefix the parameter with a plus
sign, `+` and don't assign it any other parameter value. This is similar to
when we specified a null parameter by prefixing the parameter with a dash
symbol, `-`.

Here's an example:

    /jsonws/foo/get-bar/zap-id/10172/start/0/end/1/+foo

To create an instance of an object parameter as a request parameter, make sure
you encode the `+` symbol: 

    /jsonws/foo/get-bar?zapId=10172&start=0&end=1&%2Bfoo

Here's an alternative syntax: 

    <input type="hidden" name="+foo" value=""/>

If a parameter is an abstract class or an interface, it can't be instantiated as
such. Instead, a concrete implementation class must be specified to create the
argument value. You can do this by specifying the `+` prefix before the
parameter name followed by specifying the concrete implementation class. Check
out this example: 

    /jsonws/foo/get-bar/zap-id/10172/start/0/end/1/+foo:com.liferay.impl.FooBean

Here's another way of doing it: 

    <input type="hidden" name="+foo:com.liferay.impl.FooBean" value=""/>

The examples above specify that a `com.liferay.impl.FooBean` object, presumed to
implement the class of the parameter named `foo`, is to be created. 

You can also set a concrete implementation as a value. Here's an example: 

    <input type="hidden" name="+foo" value="com.liferay.impl.FooBean"/>

In JSON RPC, here's what it looks like:

    "+foo" : "com.liferay.impl.FooBean"

All the examples above specify a concrete implementation for the `foo` service
method parameter. 

Once you pass in an object parameter, you might want to populate the object.
Find out how next. 

### Inner Parameters [](id=inner-parameters)

When you pass in an object parameter, you'll often need to populate its inner
parameters (i.e., fields). Consider a default parameter `serviceContext` of type
`ServiceContext` (see the
[ServiceContext](https://www.liferay.com/documentation/liferay-portal/6.2/development/-/ai/servicecontext-liferay-portal-6-2-dev-guide-06-en)
section of the next chapter to find out more about this type). To make an
appropriate call to JSONWS, you might need to set the `serviceContext`
parameter's fields `addGroupPermissions` and `scopeGroupId`. 

You can pass inner parameters by specifying them using dot notation. Just append
the name of the parameter with a dot (i.e., a period, `.`), followed by the name
of the inner parameter. For the `ServiceContext` inner parameters we mentioned
above, you'd specify `serviceContext.addGroupPermissions` and
`serviceContext.scopeGroupId`. They're recognized as inner parameters and their
values are injected into existing parameters before the API service method is
executed. 

Inner parameters aren't counted as regular parameters for matching methods
and are ignored during matching. 

+$$$

**Tip:** Use inner parameters with object parameters to set inner content of
created parameter instances! 

$$$

Next, let's see what values are returned when a JSON seb service is invoked. 

