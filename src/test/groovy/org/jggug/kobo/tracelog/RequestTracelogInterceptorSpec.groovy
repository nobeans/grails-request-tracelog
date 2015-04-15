package org.jggug.kobo.tracelog

import grails.test.mixin.TestFor
import grails.test.runtime.DirtiesRuntime
import grails.util.GrailsUtil
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RequestTracelogInterceptor)
class RequestTracelogInterceptorSpec extends Specification {

    @Unroll
    @DirtiesRuntime
    void "controller '#controller' should be mached: #matched"() {
        given:
        GrailsUtil.metaClass.static.isDevelopmentEnv = { -> true }

        when: "A request matches the interceptor"
        withRequest(controller: controller)

        then: "The interceptor does match"
        interceptor.doesMatch() == matched

        where:
        matched | controller
        true    | "foo"
        true    | "bar"
        false   | "assets"
    }

    @DirtiesRuntime
    void "it should match only in develoment environment"() {
        given:
        GrailsUtil.metaClass.static.isDevelopmentEnv = { -> false }

        when: "A request matches the interceptor"
        withRequest(controller: "shouldMatchedController")

        then: "The interceptor does not match"
        !interceptor.doesMatch()
    }
}
