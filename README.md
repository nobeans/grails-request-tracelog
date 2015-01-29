Grails Request Tracelog Plugin
==============================

This is a grails plugin to get debug logs of request.


Installation
------------

```
grails.project.dependency.resolution = {
    // ...
    repositories {
        // ...
        mavenRepo "http://dl.bintray.com/nobeans/maven"
    }
    plugins {
        // ...
        compile "org.jggug.kobo:request-tracelog:0.4"
    }
}
```


Usage
-----

All you have to do is to install the plugin.
Only for the "development" environment, request log emits like this:

```
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[Before Action]
Request ID: ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1
--------------------
Request attributes:
  charEncodingFilter.FILTERED = true
  com.opensymphony.sitemesh.APPLIED_ONCE = true
  grailsWebRequest.FILTERED = true
  hiddenHttpMethod.FILTERED = true
  javax.servlet.forward.context_path = /tracelog-sample
  javax.servlet.forward.request_uri = /tracelog-sample/dbdoc
  javax.servlet.forward.servlet_path = /dbdoc
  org.codehaus.grails.INCLUDED_JS_LIBRARIES = []
  org.codehaus.groovy.grails.CONTROLLER_NAME_ATTRIBUTE = dbdoc
  org.codehaus.groovy.grails.FLASH_SCOPE = [:]
  org.codehaus.groovy.grails.GRAILS_CONTROLLER_CLASS = Artefact > Dbdoc
  org.codehaus.groovy.grails.GRAILS_CONTROLLER_CLASS_AVAILABLE = true
  org.codehaus.groovy.grails.WEB_REQUEST = ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1
  org.codehaus.groovy.grails.web.sitemesh.GrailsPageFilter.GSP_SITEMESH_PAGE = org.codehaus.groovy.grails.web.sitemesh.GSPSitemeshPage@687c9bc3
  org.springframework.web.servlet.DispatcherServlet.CONTEXT = org.codehaus.groovy.grails.commons.spring.GrailsWebApplicationContext@779ea5b0: startup date [Sat Nov 22 02:30:39 JST 2014]; parent: Root WebApplicationContext
  org.springframework.web.servlet.DispatcherServlet.FLASH_MAP_MANAGER = org.springframework.web.servlet.support.SessionFlashMapManager@119f705d
  org.springframework.web.servlet.DispatcherServlet.LOCALE_RESOLVER = org.springframework.web.servlet.i18n.SessionLocaleResolver@7a89f2b4
  org.springframework.web.servlet.DispatcherServlet.OUTPUT_FLASH_MAP = [:]
  org.springframework.web.servlet.DispatcherServlet.THEME_RESOLVER = org.springframework.web.servlet.theme.FixedThemeResolver@769d4645
  org.springframework.web.servlet.DispatcherServlet.THEME_SOURCE = org.codehaus.groovy.grails.commons.spring.GrailsWebApplicationContext@779ea5b0: startup date [Sat Nov 22 02:30:39 JST 2014]; parent: Root WebApplicationContext
  urlMapping.FILTERED = true
--------------------
Request parameters:
  controller = dbdoc
--------------------
Session attributes:
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[Before Action]

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[After Action]
Request ID: ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1;session=339604B83D9CD66D1F44F08E8F8EFCE3
--------------------
Request parameters:
  controller = dbdoc
--------------------
Session attributes:
  org.codehaus.groovy.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[After Action] (time: 0.017[sec])

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[After View]
Request ID: ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1;session=339604B83D9CD66D1F44F08E8F8EFCE3
--------------------
Request parameters:
  controller = dbdoc
--------------------
Session attributes:
  org.codehaus.groovy.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[After View] (time: 0.022[sec])
```


Configuration
-------------

## Logging

You can configure log settings (e.g. log level) by using the following FQCN of the filter.

```
grails.app.filters.org.jggug.kobo.filter.RequestTracelogFilters
```


## Assets request

By default, a request for assets is ignored because it has little information for debug.
If you want not to ignore it, you can use a system property:

System property|value|description
---------------|-----|-----------------
tracelog.assets|true |emit assets log
               |false|ignored (default)
