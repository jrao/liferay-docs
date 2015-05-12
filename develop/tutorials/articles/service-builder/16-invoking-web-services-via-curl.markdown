# Invoking JSON Web Services via cURL

This tutorial explains how to invoke Liferay's JSON web services via
[cURL](http://curl.haxx.se/) and provides examples. To learn how to invoke
Liferay's JSON web services via JavaScript or URL, please see the
[Invoking JSON Web Services via JavaScript](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-javascript)
tutorial or the
[Invoking JSON Web Services via URL](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-url)
tutorial.

## Simple JSON Web Service Invocation via cURL

Let's examine a simple JSON web service invocation that's performed via URL:

    curl http://localhost:8080/api/jsonws/user/get-user-by-email-address \
      -u test@liferay.com:test \
      -d companyId=20154 \
      -d emailAddress='test@liferay.com'

The Liferay JSON web services page (its URL is
[localhost:8080/api/jsonws](localhost:8080/api/jsonws) if you're running Liferay
locally on port 8080) generates example code for invoking web services. To see
the generated code for a particular service, click on the name of the service,
enter the required parameters and click *Invoke*. The JSON result of your
service invocation appears. There are multiple ways to invoke Liferay's JSON web
services: click on *JavaScript Example*, *curl Example*, or *URL example* to see
different ways of invoking the web service.

![Figure x: When you invoke a service from Liferay's JSON web services page, you can view the result of your service invocation as well as example code for invoking the service via JavaScript, curl, or URL.](../../images/jsonws-simple-example.png)

## Related Topics

[Invoking JSON Web Services via JavaScript](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-javascript)

[Invoking JSON Web Services via URL](develop/tutorials/-/knowledge_base/6-2/invoking-json-web-services-via-url)
