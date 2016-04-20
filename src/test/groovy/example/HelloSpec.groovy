package example

import geb.spock.GebReportingSpec
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest

@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest(randomPort = true)
class HelloSpec extends GebReportingSpec {
    @Value('${local.server.port}')
    int port

    def setup() {
        browser.setBaseUrl("http://localhost:${port}")
    }

    def 'should render hello message'() {
        when:
        go '/'

        then:
        assert page.downloadText() == 'Greetings from Spring Boot!'
    }
}