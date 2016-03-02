Request Tracelog Plugin for Grails 3
====================================

This is a Grails 3 plugin to get info logs of request.


Installation
------------

In build.gradle:

    dependencies {
        compile "org.grails.plugins:request-tracelog:1.1.2"
    }


Usage
-----

All you have to do is to install the plugin.
Only in the `development` environment, three request logs emit as follows:

    Before Action
        Request ID: ServletWebRequest: uri=/myapp/sample/index;client=0:0:0:0:0:0:0:1;session=FBDC27659D49A5EB8C257F25922DA45B
        Request attributes:
            applicationContextIdFilter.FILTERED: true
            characterEncodingFilter.FILTERED: true
            grailsWebRequestFilter.FILTERED: true
            hiddenHttpMethodFilter.FILTERED: true
            metricFilter.FILTERED: true
            org.grails.ACTION_NAME_ATTRIBUTE: index
            org.grails.CONTROLLER_NAME_ATTRIBUTE: sample
            org.grails.RESPONSE_FORMATS: [MimeType { name=*/*,extension=all,parameters=[q:1.0] }]
            org.grails.WEB_REQUEST: ServletWebRequest: uri=/myapp/sample/index;client=0:0:0:0:0:0:0:1;session=FBDC27659D49A5EB8C257F25922DA45B
            org.grails.url.match.info: org.grails.web.mapping.mvc.GrailsControllerUrlMappingInfo@4989bb9a
            org.springframework.web.context.request.async.WebAsyncManager.WEB_ASYNC_MANAGER: org.springframework.web.context.request.async.WebAsyncManager@34ecd5c7
            org.springframework.web.servlet.DispatcherServlet.CONTEXT: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@9cd25ff: startup date [Fri Apr 17 17:12:42 JST 2015]; root of context hierarchy
            org.springframework.web.servlet.DispatcherServlet.FLASH_MAP_MANAGER: org.springframework.web.servlet.support.SessionFlashMapManager@57be88bf
            org.springframework.web.servlet.DispatcherServlet.LOCALE_RESOLVER: org.springframework.web.servlet.i18n.SessionLocaleResolver@3999a99f
            org.springframework.web.servlet.DispatcherServlet.OUTPUT_FLASH_MAP: [:]
            org.springframework.web.servlet.DispatcherServlet.THEME_RESOLVER: org.springframework.web.servlet.theme.FixedThemeResolver@454ef3ee
            org.springframework.web.servlet.DispatcherServlet.THEME_SOURCE: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@9cd25ff: startup date [Fri Apr 17 17:12:42 JST 2015]; root of context hierarchy
            webRequestLoggingFilter.FILTERED: true
        Request parameters:
            action: index
            controller: sample
        Session attributes:
            org.grails.FLASH_SCOPE: [:]
        Cookies:
            JSESSIONID: FBDC27659D49A5EB8C257F25922DA45B (domain=null, path=null, maxAge=-1, secure=false, comment=null)

    After Action (time: 0.009[sec])
        Request ID: ServletWebRequest: uri=/myapp/sample/index;client=0:0:0:0:0:0:0:1;session=FBDC27659D49A5EB8C257F25922DA45B
        Request parameters:
            action: index
            controller: sample
        Session attributes:
            org.grails.FLASH_SCOPE: [:]
        Cookies:
            JSESSIONID: FBDC27659D49A5EB8C257F25922DA45B (domain=null, path=null, maxAge=-1, secure=false, comment=null)

    After View (time: 0.011[sec])
        Request ID: ServletWebRequest: uri=/myapp/sample/index;client=0:0:0:0:0:0:0:1;session=FBDC27659D49A5EB8C257F25922DA45B
        Request parameters:
            action: index
            controller: sample
        Session attributes:
            org.grails.FLASH_SCOPE: [:]
        Cookies:
            JSESSIONID: FBDC27659D49A5EB8C257F25922DA45B (domain=null, path=null, maxAge=-1, secure=false, comment=null)


Configuration
-------------

### Logging

You can configure log settings (e.g. log level) by using the following FQCN of the interceptor.

    grails.app.controllers.request.tracelog.RequestTracelogInterceptor


Code Status
-----------

[![Build Status](https://travis-ci.org/nobeans/grails-request-tracelog.svg?branch=master)](https://travis-ci.org/nobeans/grails-request-tracelog)


License
-------

This is released under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0)
