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

package org.jggug.kobo.tracelog

import grails.util.GrailsUtil

class RequestTracelogFilters {

    private static traceLog(log, request, params, session, needRequestAttr = true) {
        log.debug "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"]
        if (needRequestAttr) {
            log.debug "-"*20
            log.debug "Request attributes:"
            request.getAttributeNames().collect({it}).sort().each {
                log.debug "  ${it} = ${request.getAttribute(it)}"
            }
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
    }

    def filters = {
        if (GrailsUtil.isDevelopmentEnv()) { // only in development mode
            all(controller:'*', action:'*') {
                before = {
                    request.startedTime = System.currentTimeMillis()
                    log.debug "[Before Action]".padRight(60, ">")
                    traceLog(log, request, params, session, true)
                    log.debug "-"*20
                    log.debug "[Before Action]".padLeft(60, "<")
                }
                after = {
                    log.debug "[After Action]".padRight(60, ">")
                    traceLog(log, request, params, session, false)
                    log.debug "-"*20
                    def time = (System.currentTimeMillis() - request.startedTime) / 1000.0
                    log.debug "[After Action] (time: ${time}[sec])".padLeft(60, "<")
                }
                afterView = {
                    log.debug "[After View]".padRight(60, ">")
                    traceLog(log, request, params, session, false)
                    log.debug "-"*20
                    def time = (System.currentTimeMillis() - request.startedTime) / 1000.0
                    log.debug "[After View] (time: ${time}[sec])".padLeft(60, "<")
                }
            }
        }
    }
}

