package request.tracelog

import grails.plugins.*

class RequestTracelogGrailsPlugin extends Plugin {

    def groupId = 'org.jggug.kobo'
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp",
        "grails-app/domain/test/**",
        "grails-app/i18n/**",
    ]
    def title = "Request Tracelog"
    def author = "Yasuharu NAKANO"
    def authorEmail = "ynak@jggug.org"
    def license = "APACHE"
    def description = '''\\
This plugin has a Filter to output some information of request/response to standard output.
It's useful for debugging.
Logging is active only at development environment.
It's very simple.
'''
    def profiles = ['web']
    def documentation = "http://github.com/nobeans/grails-request-tracelog/"
    def scm = [url: "https://github.com/nobeans/grails-request-tracelog/"]
    def issueManagement = [system: "GitHub Issues", url: "https://github.com/nobeans/grails-request-tracelog/issues"]
}
