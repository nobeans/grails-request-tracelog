import grails.util.GrailsUtil

class RequestTracelogFilters {

    def filters = {
        if (GrailsUtil.isDevelopmentEnv()) { // only in development mode
            all(controller:'*', action:'*') {
                before = {
                    request.startedTime = System.currentTimeMillis()
                    log.debug "[Before Action]".padRight(60, ">")
                    log.debug "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"]
                    log.debug "-"*20
                    log.debug "Request attributes:"
                    request.getAttributeNames().collect({it}).sort().each {
                        log.debug "  ${it} = ${request.getAttribute(it)}"
                    }
                    log.debug "-"*20
                    log.debug "Request parameters:"
                    params.keySet().sort().each {
                        log.debug "  ${it} = ${params[it]}"
                    }
                    log.debug "-"*20
                    log.debug "Session attributes:"
                    session.getAttributeNames().collect({it}).sort().each {
                        log.debug "  ${it} = ${session.getAttribute(it)}"
                    }
                    log.debug "-"*20
                    log.debug "[Before Action]".padLeft(60, "<")
                }
                after = {
                    log.debug "[After Action]".padRight(60, ">")
                    log.debug "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"]
                    log.debug "-"*20
                    log.debug "Request parameters:"
                    params.keySet().sort().each {
                        log.debug "  ${it} = ${params[it]}"
                    }
                    log.debug "-"*20
                    log.debug "Session attributes:"
                    session.getAttributeNames().collect({it}).sort().each {
                        log.debug "  ${it} = ${session.getAttribute(it)}"
                    }
                    log.debug "-"*20
                    def time = (System.currentTimeMillis() - request.startedTime) / 1000.0
                    log.debug "[After Action] (time: ${time}[sec])".padLeft(60, "<")
                }
                afterView = {
                    log.debug "[After View]".padRight(60, ">")
                    log.debug "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"]
                    log.debug "-"*20
                    log.debug "Request parameters:"
                    params.keySet().sort().each {
                        log.debug "  ${it} = ${params[it]}"
                    }
                    log.debug "-"*20
                    log.debug "Session attributes:"
                    session.getAttributeNames().collect({it}).sort().each {
                        log.debug "  ${it} = ${session.getAttribute(it)}"
                    }
                    log.debug "-"*20
                    def time = (System.currentTimeMillis() - request.startedTime) / 1000.0
                    log.debug "[After View] (time: ${time}[sec])".padLeft(60, "<")
                }
            }
        }
    }
}

