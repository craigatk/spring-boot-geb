package example

class AccountPage extends geb.Page {
    static url = '/bank/account'

    static at = { title == 'Bank Account' }

    static content = {
        currentBalanceField { $("#current-balance") }

        depositAmountField { $("#amount") }
        depositButton(to: DepositSuccessPage) { $("#deposit-button") }
    }

    BigDecimal getCurrentBalance() {
        currentBalanceField.text().trim().toBigDecimal()
    }

    DepositSuccessPage depositAmount(BigDecimal amount) {
        depositAmountField.value(amount)

        depositButton.click()

        return browser.page
    }
}
