/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class RequestTracelogGrailsPlugin {
    def groupId = 'org.jggug.kobo'
    // the plugin version
    def version = "0.4"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
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
    def documentation = "http://github.com/nobeans/grails-request-tracelog/"
    def scm = [url: "https://github.com/nobeans/grails-request-tracelog/"]
    def issueManagement = [system: "GitHub Issues", url: "https://github.com/nobeans/grails-request-tracelog/issues"]
}
