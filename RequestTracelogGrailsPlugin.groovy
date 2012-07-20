class RequestTracelogGrailsPlugin {
    // the plugin version
    def version = "0.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.1.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp",
        "grails-app/domain/test/**",
        "grails-app/i18n/**",
        "web-app/**",
        "scripts/**",
    ]
    def author = "nobeans"
    def authorEmail = "nobeans@gmail.com"
    def title = "filter for debug logging"
    def description = '''\\
This plugin has a Filter to output some information of request/response to standard output.
It's useful for debugging.
Logging is active only at development environment.
It's very simple.
'''
}
