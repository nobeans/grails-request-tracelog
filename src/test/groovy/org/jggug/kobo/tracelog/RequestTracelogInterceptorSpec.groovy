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

    @DirtiesRuntime
    void "it should match only in develoment environment"() {
        given:
        GrailsUtil.metaClass.static.isDevelopmentEnv = { -> dev }

        when: "A request matches the interceptor"
        withRequest(controller: "shouldMatchedController")

        then: "The interceptor does not match"
        interceptor.doesMatch() == matched

        where:
        dev   | matched
        true  | true
        false | false
    }
}
