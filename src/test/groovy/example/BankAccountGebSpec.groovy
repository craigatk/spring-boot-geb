package example

class BankAccountGebSpec extends BaseGebSpec {
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
