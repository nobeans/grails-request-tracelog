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

    private static final String SEP = System.lineSeparator()

    private static format(label, request, params, session) {
        def buff = new StringBuilder()
        buff << label << SEP // for the first line
        buff << "[${label}]".padLeft(80, ">") << SEP
        buff << "Request ID: " + request["org.codehaus.groovy.grails.WEB_REQUEST"] << SEP
        if (!request.startedTime) {
            buff << "-"*20 << SEP
            buff << "Request attributes:" << SEP
            request.getAttributeNames().collect({it}).sort().each {
                buff << "  ${it} = ${request.getAttribute(it)}" << SEP
            }
        }
        buff << "-"*20 << SEP
        buff << "Request parameters:" << SEP
        params.keySet().sort().each {
            buff << "  ${it} = ${params[it]}" << SEP
        }
        buff << "-"*20 << SEP
        buff << "Session attributes:" << SEP
        session.getAttributeNames().collect({it}).sort().each {
            buff << "  ${it} = ${session.getAttribute(it)}" << SEP
        }
        buff << "-"*20 << SEP
        def time = ""
        if (request.startedTime) {
            time = " (time: ${(System.currentTimeMillis() - request.startedTime) / 1000.0}[sec])"
        }
        buff << "[${label}]${time}".padLeft(80, "<") << SEP
        return buff.toString().trim()
    }

    private static isTarget(params) {
        if (params.controller != "assets") {
            return true
        }
        // As default, a assets request is ignored without specifying a certain system property.
        def assetsProp = System.getProperty("tracelog.assets")
        if (assetsProp != null) {
            return Boolean.valueOf(assetsProp)
        }
        return false
    }

    def filters = {
        if (GrailsUtil.isDevelopmentEnv()) { // only in development mode
            all(controller:'*', action:'*') {
                before = {
                    if (!isTarget(params)) return
                    log.debug format("Before Action", request, params, session)
                    request.startedTime = System.currentTimeMillis()
                }
                after = {
                    if (!isTarget(params)) return
                    log.debug format("After Action", request, params, session)
                }
                afterView = {
                    if (!isTarget(params)) return
                    log.debug format("After View", request, params, session)
                }
            }
        }
    }
}

