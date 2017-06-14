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

package request.tracelog

import grails.util.GrailsUtil

class RequestTracelogInterceptor {

    RequestTracelogInterceptor() {
        if (GrailsUtil.isDevelopmentEnv()) {
            matchAll()
        }
    }

    boolean before() {
        log.info format("Before Action", request, params)
        request.startedTime = System.currentTimeMillis()
        true
    }

    boolean after() {
        log.info format("After Action", request, params)
        true
    }

    void afterView() {
        log.info format("After View", request, params)
    }

    private static format(label, request, params) {
        def sw = new StringWriter()
        def p = new IndentPrinter(sw, ' ' * 4)
        def row = { message ->
            p.printIndent()
            p.println message
        }

        if (request.startedTime) {
            row "$label (time: ${(System.currentTimeMillis() - request.startedTime) / 1000.0}[sec])"
        } else {
            row label
        }

        p.incrementIndent()
        row "Request ID: " + request["org.grails.WEB_REQUEST"]

        if (!request.startedTime) {
            row "Request attributes:"
            p.incrementIndent()
            request.getAttributeNames().collect({it}).sort().each {
                row "${it}: ${request.getAttribute(it)}"
            }
            p.decrementIndent()
        }

        row "Request parameters:"
        p.incrementIndent()
        params.keySet().sort().each {
            row "${it}: ${params[it]}"
        }
        p.decrementIndent()

        row "Session attributes:"
        p.incrementIndent()
        def session = request.getSession(false)
        if (session) {
            session.getAttributeNames().collect({it}).sort().each {
                row "${it}: ${session.getAttribute(it)}"
            }
        } else {
            row "(Session is not found)"
        }
        p.decrementIndent()

        row "Cookies:"
        p.incrementIndent()
        request.cookies?.sort { it.name }?.each {
            row "${it.name}: ${it.value} (domain=${it.domain}, path=${it.path}, maxAge=${it.maxAge}, secure=${it.secure}, comment=${it.comment})"
        }
        p.decrementIndent()

        return sw.toString().trim()
    }
}

