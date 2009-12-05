import grails.util.GrailsUtil

class RequestTracelogFilters {

    def filters = {
        if (GrailsUtil.isDevelopmentEnv()) { // only in development mode
            all(controller:'*', action:'*') {
                before = {
                    request.startedTime = System.currentTimeMillis()
                    println "[Before Action]".padRight(60, ">")
                    println "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"]
                    println "-"*20
                    println "Request attributes:"
                    request.getAttributeNames().collect({it}).sort().each {
                        println "  ${it} = ${request.getAttribute(it)}"
                    }
                    println "-"*20
                    println "Request parameters:"
                    params.keySet().sort().each {
                        println "  ${it} = ${params[it]}"
                    }
                    println "-"*20
                    println "Session attributes:"
                    session.getAttributeNames().collect({it}).sort().each {
                        println "  ${it} = ${session.getAttribute(it)}"
                    }
                    println "-"*20
                    println "[Before Action]".padLeft(60, "<")
                }
                after = {
                    println "[After Action]".padRight(60, ">")
                    println "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"]
                    println "-"*20
                    println "Request parameters:"
                    params.keySet().sort().each {
                        println "  ${it} = ${params[it]}"
                    }
                    println "-"*20
                    println "Session attributes:"
                    session.getAttributeNames().collect({it}).sort().each {
                        println "  ${it} = ${session.getAttribute(it)}"
                    }
                    println "-"*20
                    def time = (System.currentTimeMillis() - request.startedTime) / 1000.0
                    println "[After Action] (time: ${time}[sec])".padLeft(60, "<")
                }
                afterView = {
                    println "[After View]".padRight(60, ">")
                    println "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"]
                    println "-"*20
                    println "Request parameters:"
                    params.keySet().sort().each {
                        println "  ${it} = ${params[it]}"
                    }
                    println "-"*20
                    println "Session attributes:"
                    session.getAttributeNames().collect({it}).sort().each {
                        println "  ${it} = ${session.getAttribute(it)}"
                    }
                    println "-"*20
                    def time = (System.currentTimeMillis() - request.startedTime) / 1000.0
                    println "[After View] (time: ${time}[sec])".padLeft(60, "<")
                }
            }
        }
    }
}
