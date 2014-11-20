grails.project.work.dir = 'target'
grails.project.source.level = 1.6

grails.project.repos.bintray.url = "https://api.bintray.com/maven/nobeans/maven/grails-request-tracelog"
grails.project.repos.default = "bintray"

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()

        mavenRepo "http://dl.bintray.com/upennlib/maven"
    }

    plugins {
        build(':release:2.2.0', ':rest-client-builder:1.0.3', ':bintray-upload:0.2') {
            export = false
        }
    }
}
