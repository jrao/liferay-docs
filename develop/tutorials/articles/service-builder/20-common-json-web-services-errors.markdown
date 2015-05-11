## Common JSON Web Service Errors [](id=common-json-web-service-errors)

While working with JSON web services, you may encounter errors. Let's look at
the most common errors in the following subsections. 

<!--I would have put the subsections in an unordered list, but I'll leave them
for now. Which is preferred? Are they long enough to warrant subsections? --> 

<!-- No, they're not long enough. In fact, that's been a problem with this whole
chapter. I removed some sections already. One way to fix some of the "missing
transition" problems above would be to combine some of the sections. -Rich -->

-   Authenticated access required

    If you see this error, it means you don't have permission to invoke the
    remote service. Double-check that you're signed in as a user with the
    appropriate permissions. If necessary, sign in as an administrator to invoke
    the remote service.

-   Missing value for parameter 
    
    If you see this error, you didn't pass a parameter value along with the
    parameter name in your URL path. The parameter value must follow the
    parameter name, like in this example: 

        /api/jsonws/user/get-user-by-id/userId

    The path above specifies a parameter named `userId`, but doesn't specify
    the parameter's value. You can resolve this error by providing the
    parameter value after the parameter name: 

        /api/jsonws/user/get-user-by-id/userId/173

-   No JSON web service action associated 

    This is error means no service method could be matched with the provided
    data (method name and argument names). This can be due to various reasons:
    arguments may be misspelled, the method name may be formatted incorrectly,
    etc. Since JSON web services reflect the underlying Java API, any changes in
    the respective Java API will automatically be propagated to the JSON web
    services. For example, if a new argument is added to a method or an existing
    argument is removed from a method, the parameter data must match that of the
    new method signature.

-   Unmatched argument type 

    This error appears when you try to instantiate a method argument using an
    incompatible argument type.

-   Judgment Day

    We hope you never see this error. It means that Skynet has initiated a
    nuclear war and most of humanity will be wiped out; survivors will need to
    battle *Terminator* cyborgs. If you see this error and survive *Judgment
    Day*, we recommend joining the resistance--they'll likely need good
    developers to support the cause, especially those familiar with time travel. 

    Had you going there, didn't we? 

Next, we'll show you how to optimize your use of JSON web services by using the
*JSON Web Services Invoker*. 

