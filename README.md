Request Tracelog Plugin for Grails 3
====================================

This is a Grails 3 plugin to get info logs of request.


Installation
------------

In build.gradle:

    dependencies {
        compile "org.grails.plugins:request-tracelog:1.0.0"
    }


Usage
-----

All you have to do is to install the plugin.
Only for the `development` environment, request log emits like this:

```
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[Before Action]
Request ID: ServletWebRequest: uri=/myapp/sample/create;client=0:0:0:0:0:0:0:1;session=8DDD9473535409FB1C32CE0EF7BC6435
--------------------
Request attributes:
  applicationContextIdFilter.FILTERED = true
  characterEncodingFilter.FILTERED = true
  grailsWebRequestFilter.FILTERED = true
  hiddenHttpMethodFilter.FILTERED = true
  metricFilter.FILTERED = true
  org.grails.ACTION_NAME_ATTRIBUTE = create
  org.grails.CONTROLLER_NAME_ATTRIBUTE = sample
  org.grails.RESPONSE_FORMATS = [MimeType { name=*/*,extension=all,parameters=[q:1.0] }]
  org.grails.WEB_REQUEST = ServletWebRequest: uri=/myapp/sample/create;client=0:0:0:0:0:0:0:1;session=672546FE67F11E3953E356948F962CE8
  org.grails.url.match.info = org.grails.web.mapping.mvc.GrailsControllerUrlMappingInfo@444b492d
  webRequestLoggingFilter.FILTERED = true
--------------------
Request parameters:
  action = create
  controller = sample
--------------------
Session attributes:
  org.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[Before Action]

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[After Action]
Request ID: ServletWebRequest: uri=/myapp/sample/create;client=0:0:0:0:0:0:0:1;session=8DDD9473535409FB1C32CE0EF7BC6435
--------------------
Request parameters:
  action = create
  controller = sample
--------------------
Session attributes:
  org.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[After Action] (time: 0.001[sec])

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[After View]
Request ID: ServletWebRequest: uri=/myapp/sample/create;client=0:0:0:0:0:0:0:1;session=8DDD9473535409FB1C32CE0EF7BC6435
--------------------
Request parameters:
  action = create
  controller = sample
--------------------
Session attributes:
  org.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[After View] (time: 0.415[sec])
```


Configuration
-------------

### Logging

You can configure log settings (e.g. log level) by using the following FQCN of the interceptor.

    grails.app.controllers.request.tracelog.RequestTracelogInterceptor

