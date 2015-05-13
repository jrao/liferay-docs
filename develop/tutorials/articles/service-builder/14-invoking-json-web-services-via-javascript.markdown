# Invoking JSON Web Services via JavaScript

This tutorial explains how to invoke Liferay's JSON web services via JavaScript
and provides examples. To learn how to invoke Liferay's JSON web services via
URL or cURL, please see the
[Invoking JSON Web Services via URL](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-url)
tutorial or the
[Invoking JSON Web Services via cURL](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-curl)
tutorial.

## Loading AlloyUI

Liferay web pages use the AlloyUI JavaScript framework. Among the JavaScript
objects created for each Liferay page is a `Liferay` object. This object
includes a `Service` function that can be used to invoke Liferay's API. To
invoke Liferay web services via `Liferay.Service(...)`, your JavaScript context
must include the AlloyUI JavaScript framework. Liferay 6.2 uses AlloyUI 2.0.x.
If you're working in a JSP, you can load the AlloyUI taglib and wrap your
JavaScript code in an `<aui:script>` tag. Here's the required import:

    <%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

To load specific AUI modules, specify them via the `use` attribute. (By default,
the `<aui:script>` tag includes the base AUI module.) For example, to use the
AUI `node` and `event` modules, wrap your code like this:

    <aui:script use="node, event">
        // Liferay service invocation here
    </aui:script>

If you're not working in a JSP, you won't have access to taglibs. In this case,
you can create an AUI context manually. For example, use the following HTML
fragment to load the AUI seed and CSS files:

    <script src="http://cdn.alloyui.com/2.0.0/aui/aui-min.js"></script>
    <link href="http://cdn.alloyui.com/2.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>

Then you can create an AUI context like this:

    AUI().use('aui-base', function(A){
        // Liferay service invocation here
    });

## Simple JSON Web Service Invocation via JavaScript

Let's examine a simple JSON web service invocation in JavaScript:

    Liferay.Service(
        '/user/get-user-by-email-address`,
        {
            companyId: Liferay.ThemeDisplay.getCompanyId(),
            emailAddress: 'test@liferay.com`
        },
        function(obj) {
            console.log(obj);
        }
    );

If you run this code, the test@liferay.com user (JSON object) is logged to the
JavaScript console.

The `Liferay.Service(...)` function takes three arguments:

1. A string representing the service being invoked
2. A parameters object
3. A callback function

The callback function takes the result of the service invocation as an argument.

## Related Topics

[Invoking JSON Web Services via URL](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-url)

[Invoking JSON Web Services via cURL](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-curl)
