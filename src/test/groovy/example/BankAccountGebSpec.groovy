package example

import geb.spock.GebReportingSpec
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest

@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest(randomPort = true)
class BankAccountGebSpec extends GebReportingSpec {
    @Value('${local.server.port}')
    int port

    def setup() {
        browser.setBaseUrl("http://localhost:${port}")
    }

    def "should deposit amount into bank account"() {
        when:
        AccountPage accountPage = to(AccountPage)

        then:
        assert accountPage.currentBalance == 0

        when:
        DepositSuccessPage depositSuccessPage = accountPage.depositAmount(100)

        then:
        assert depositSuccessPage.depositAmount == 100
        assert depositSuccessPage.newBalance == 100
    }
}
