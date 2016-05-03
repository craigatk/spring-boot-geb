package example

import geb.spock.GebReportingSpec
import spock.lang.Ignore

@Ignore // Uncomment this annotation to run the test
class GoogleSearchGebSpec extends GebReportingSpec {
    def 'should search for Geb in Google'() {
        given:
        go "http://www.google.com"

        when:
        $("input", name: "q").value("Geb")
        $("button", name: "btnG").click()

        then:
        waitFor { $("#search").displayed }

        assert $("#search").text().contains("gebish.org")
    }
}
