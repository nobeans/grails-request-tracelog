grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.7
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenCentral()
        //mavenLocal()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
    }

    plugins {
        build(
            ":tomcat:$grailsVersion",
            ":release:2.0.3",
        ) {
            export = false
        }
        test(
            ":hibernate:$grailsVersion",
            ":spock:0.6",
        ) {
            export = false
        }
        runtime ":svn:1.0.2"
    }
}
