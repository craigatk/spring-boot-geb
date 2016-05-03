package example

class DepositSuccessPage extends geb.Page {
    static at = { title == 'Successful Deposit' }

    static content = {
        depositAmountField { $("#deposit-amount") }
        newBalanceField { $("#new-balance") }
    }

    BigDecimal getDepositAmount() {
        depositAmountField.text().trim().toBigDecimal()
    }

    BigDecimal getNewBalance() {
        newBalanceField.text().trim().toBigDecimal()
    }
}
