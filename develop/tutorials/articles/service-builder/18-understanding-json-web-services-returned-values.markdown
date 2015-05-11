## Returned Values [](id=returned-values)

No matter how a JSON web service is invoked, it returns a JSON string that
represents the service method result. Returned objects are *loosely* serialized
to a JSON string and returned to the caller. 

Let's look at some values returned from service calls. We'll create a
`UserGroup` as we did in our SOAP web service client examples. To make it easy,
we'll use the test form provided with the JSON web service in our browser. 

1.  Sign in to your portal as an administrator and then point your browser to
    the JSON web service method that adds a `UserGroup`: 

        http://127.0.0.1:8080/api/jsonws?signature=/usergroup/add-user-group-2-\
        name-description

    Note, we've inserted line escape character `\` in order to fit the example
    URL on this page.

    Alternatively, navigate to it by starting at
    `http://127.0.0.1:8080/api/jsonws` then scrolling down to the section for
    *UserGroup*; click *add-user-group*. 

2.  In the *name* field, enter *UserGroup3* and set the description to an
    arbitrary value like *Created via JSON WS*.

3.  Click *Invoke* and you'll get a result similar to the following: 

        {
          "addedByLDAPImport": false,
          "companyId": 10154,
          "createDate": 1382460167254,
          "description": "Created via JSON WS",
          "modifiedDate": 1382460167254,
          "name": "UserGroup3",
          "parentUserGroupId": 0,
          "userGroupId": 13901,
          "userId": 10198,
          "userName": "Test Test",
          "uuid": "1b18c73d-482a-4772-b6f4-a9253bbcbf92"
        }

The returned `String` represents the `UserGroup` object you just created,
serialized into a JSON string. To find out more about JSON strings, go to
[json.org](http://www.json.org/). 

Let's check out some common JSON WebService errors. 

