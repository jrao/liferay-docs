## Invoking JSON Web Services [](id=invoking-json-web-services)

How you invoke a JSON web service depends on how you pass in its parameters.
We'll discuss how to pass in parameters below, but first you need to understand
how your invocation is matched to a method, especially when a service method is
overloaded. 

The general rule is that you provide the method name and *all* parameters for
that service method--even if you only provide `null`. 

It's important to provide all parameters, but it doesn't matter *how* you do it
(e.g., as part of the URL line, as request parameters, etc.). The order of the
parameters doesn't matter either. 

+$$$

**Note:** An authentication related token must accompany each Liferay web
service invocation. For details, please see the
[Understanding Liferay's Service Security Model](https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/understanding-liferays-service-security-model)
tutorial. 

$$$

Exceptions abound in life, and there's an exception to the rule that *all*
parameters are required--when using numeric *hints* to match methods. Let's look
at using hints next. 

### Using Hints [](id=using-hints)

Adding numeric hints lets you specify how many method arguments a service has.
If you don't specify an argument for a parameter, it's automatically
passed in as `null`. Syntactically, you can add hints as numbers separated by a
dot in the method name. Here's an example: 

    /foo/get-bar.2/param1/123/-param2

Here, the `.2` is a numeric hint specifying that only service methods with two
arguments will be matched; others will be ignored for matching. 

There's an important distinction to make between matching using hints and
matching without hints. When a hint is specified, you don't have to specify all
of the parameters. Any missing arguments are treated as `null`. The previous
example may be called like this:

    /foo/get-bar.2/param1/123

In this example, `param2` will automatically be set to `null`. 

Find out how to pass parameters as part of the URL path next. 

### Passing Parameters as Part of a URL Path [](id=passing-parameters-as-part-of-a-url-path)

You can pass parameters as part of the URL path. After the service URL, just
specify method parameters in name-value pairs. Parameter names must be formed
from method argument names by converting them from camelCase to names using all
lower case and separated-by-dash. Here's an example of calling one of the
portal's services: 

    http://localhost:8080/api/jsonws/dlapp/get-file-entries/repository-id/\
    10172/folder-id/0

Note, we've inserted line escape character `\` in order to fit the example URL
on this page. 

You can pass parameters in any order; it's not necessary to follow the order in
which the arguments specified in the method signatures. 

When a method name is overloaded, the *best match* will be used. It chooses the
method that contains the least number of undefined arguments and invokes it for
you. 

You can also pass parameters in a URL query, and we'll show you how next. 

### Passing Parameters as a URL Query [](id=passing-parameters-as-a-url-query)

You can pass in parameters as request parameters. Parameter names are specified
as is (e.g. camelCase) and are set equal to their argument values, like this: 

    http://localhost:8080/api/jsonws/dlapp/get-file-entries?repositoryId=\
    10172&folderId=0

Note, we've inserted line escape character `\` in order to fit the example URL
on this page.

As with passing parameters as part of a URL path, the parameter order is not
important, and the *best match* rule applies for overloaded methods. 

Now you know a few different ways to pass parameters. It's also possible to pass
URL parameters in a mixed way. Some can be part of the URL path and some can be
specified as request parameters.

Parameter values are sent as strings using the HTTP protocol. Before a matching
Java service method is invoked, each parameter value is converted from a
`String` to its target Java type. Liferay uses a third party open source library
to convert each object to its appropriate common type. It's possible to add or
change the conversion for certain types but we'll just cover the standard
conversions process. 

Conversion for common types (e.g., `long`, `String`, `boolean`) is
straightforward. Dates can be given in milliseconds; locales can be passed as
locale names (e.g. `en` and `en_US`). To pass in an array of numbers, send a
`String` of comma-separated numbers (e.g. `String` `4,8,15,16,23,42` can be
converted to `long[]` type). You get the picture!

In addition to the common types, arguments can be of type `List` or `Map`. To
pass a `List` argument, send a JSON array. To pass a `Map` argument, send a JSON
object. The conversion of these is done in two steps, ingeniously referred to
below as *Step 1* and *Step 2*:

- *Step 1--JSON deserialization*: JSON arrays are converted into `List<String>`
  and JSON objects are converted to `Map<String, String>`. For security reasons,
  it is forbidden to instantiate any type within JSON deserialization. 
- *Step 2--Generification*: Each `String` element of the `List` and `Map` is
  converted to its target type (the argument's generic Java type specified in
  the method signature). This step is only executed if the Java argument type
  uses generics. 

As an example, let's consider the conversion of `String` array `[en,fr]` as JSON
web service parameters for a `List<Locale>` Java method argument type: 

- *Step 1--JSON deserialization*: The JSON array is deserialized to a
  `List<String>` containing `String`s `en` and `fr`. 

- *Step 2--Generification*: Each `String` is converted to the `Locale` (the
  generic type), resulting in the `List<Locale>` Java argument type. 

Now let's see how to specify an argument as `null`. 

### Sending NULL Values [](id=sending-null-values)

To pass a `null` value for an argument, prefix the parameter name with a dash.
Here's an example: 

    .../dlsync/get-d-l-sync-update/company-id/10151/repository-id/10195/-last-access-date

The `last-access-date` parameter is interpreted as `null`. Although we have it
last in the URL above, it's not necessary.

Null parameters don't have specified values. When a null parameter is passed as
a request parameter, its value is ignored and `null` is used instead: 

    <input type="hidden" name="-last-access-date" value=""/>

When using JSON RPC (see below), you can send null values explicitly, even
without a prefix. Here's an example: 

    "last-access-date":null

Now let's learn about encoding parameters. 

### Encoding Parameters [](id=encoding-parameters)

There's a difference between URL encoding and query (i.e. request parameters)
encoding. The difference lies in how the space character is encoded. When the
space character is part of the URL path, it's encoded as `%20`; when it's part
of the query it's encoded as a plus sign (`+`).

All these encoding rules apply to ASCII and international (non-ASCII)
characters. Since Liferay Portal works in UTF-8 mode, parameter values must be
encoded as UTF-8 values. Liferay Portal doesn't decode request URLs and request
parameter values to UTF-8 itself; it relies on the web server layer. When
accessing services through JSON-RPC, encoding parameters to UTF-8 isn't
enough--you need to send the encoding type in a Content-Type header (e.g.
`Content-Type : "text/plain; charset=utf-8"`). 

For example, let's pass the value "&#1057;&#1091;&#1087;&#1077;&#1088;" ("Super"
in Cyrillic) to some JSON Web Service method. This name first has to be
converted to UTF-8 (resulting in array of 10 bytes) and then encoded for URLs or
request parameters. The resulting value is the string
`%D0%A1%D1%83%D0%BF%D0%B5%D1%80` that can be passed to our service method. When
received, this value is first going to be translated to an array of 10 bytes
(URL decoded) and then converted to a UTF-8 string of the 5 original characters.

Did you know you can send files as arguments? Find out how next. 

### Sending Files as Arguments [](id=sending-files-as-arguments)

Files can be uploaded using multipart forms and requests. Here's an example: 

    <form
     action="http://localhost:8080/api/jsonws/dlapp/add-file-entry"
     method="POST"
     enctype="multipart/form-data">
        <input type="hidden" name="repositoryId" value="10172"/>
        <input type="hidden" name="folderId" value="0"/>
        <input type="hidden" name="title" value="test.jpg"/>
        <input type="hidden" name="description" value="File upload example"/>
        <input type="hidden" name="changeLog" value="v1"/>
        <input type="file" name="file"/>
        <input type="submit" value="addFileEntry(file)"/>
    </form>

This is a common upload form that invokes the `addFileEntry` method of the
`DLAppService` class. 

Now we'll show you how to invoke JSON web services using JSON RPC. 

