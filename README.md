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
        compile "org.jggug.kobo:request-tracelog:0.2"
    }
}
```


Usage
-----

All you have to do is to install the plugin.
Only under the "development" environment, an request log emit like this:

```
[Before Action]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Request ID: ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1;session=51CEBD93943E7EDF55748BDDB27637C3
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
  org.codehaus.groovy.grails.GRAILS_CONTROLLER_CLASS = Artefact > Dbdoc
  org.codehaus.groovy.grails.GRAILS_CONTROLLER_CLASS_AVAILABLE = true
  org.codehaus.groovy.grails.WEB_REQUEST = ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1;session=51CEBD93943E7EDF55748BDDB27637C3
  org.codehaus.groovy.grails.web.sitemesh.GrailsPageFilter.GSP_SITEMESH_PAGE = org.codehaus.groovy.grails.web.sitemesh.GSPSitemeshPage@6d89d9eb
  org.springframework.web.servlet.DispatcherServlet.CONTEXT = org.codehaus.groovy.grails.commons.spring.GrailsWebApplicationContext@21f9c7a1: startup date [Thu Nov 20 09:17:56 JST 2014]; parent: Root WebApplicationContext
  org.springframework.web.servlet.DispatcherServlet.FLASH_MAP_MANAGER = org.springframework.web.servlet.support.SessionFlashMapManager@75420b7b
  org.springframework.web.servlet.DispatcherServlet.LOCALE_RESOLVER = org.springframework.web.servlet.i18n.SessionLocaleResolver@42fff461
  org.springframework.web.servlet.DispatcherServlet.OUTPUT_FLASH_MAP = [:]
  org.springframework.web.servlet.DispatcherServlet.THEME_RESOLVER = org.springframework.web.servlet.theme.FixedThemeResolver@32052ea4
  org.springframework.web.servlet.DispatcherServlet.THEME_SOURCE = org.codehaus.groovy.grails.commons.spring.GrailsWebApplicationContext@21f9c7a1: startup date [Thu Nov 20 09:17:56 JST 2014]; parent: Root WebApplicationContext
  startedTime = 1416442690544
  urlMapping.FILTERED = true
--------------------
Request parameters:
  controller = dbdoc
--------------------
Session attributes:
  org.codehaus.groovy.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[Before Action]
[After Action]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Request ID: ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1;session=51CEBD93943E7EDF55748BDDB27637C3
--------------------
Request parameters:
  controller = dbdoc
--------------------
Session attributes:
  org.codehaus.groovy.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<[After Action] (time: 0.028[sec])
[After View]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Request ID: ServletWebRequest: uri=/tracelog-sample/grails/dbdoc.dispatch;client=0:0:0:0:0:0:0:1;session=51CEBD93943E7EDF55748BDDB27637C3
--------------------
Request parameters:
  controller = dbdoc
--------------------
Session attributes:
  org.codehaus.groovy.grails.FLASH_SCOPE = [:]
--------------------
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[After View] (time: 0.032[sec])
```


Configuration
-------------

You can configure log settings (e.g. log level) by using the following FQCN of the filter.

```
grails.app.filters.org.jggug.kobo.filter.RequestTracelogFilters
```

