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

class RequestTracelogInterceptor {

    private static final String SEP = System.lineSeparator()

    RequestTracelogInterceptor() {
        if (!GrailsUtil.isDevelopmentEnv()) return // only in development mode

        // As default, a assets request is ignored without specifying a certain system property.
        if (Boolean.getBoolean("tracelog.assets")) {
            matchAll()
        } else {
            matchAll().excludes(controller: 'assets')
        }
    }

    boolean before() {
        log.debug format("Before Action", request, params, session)
        request.startedTime = System.currentTimeMillis()
        true
    }

    boolean after() {
        log.debug format("After Action", request, params, session)
        true
    }

    void afterView() {
        log.debug format("After View", request, params, session)
    }

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
}

