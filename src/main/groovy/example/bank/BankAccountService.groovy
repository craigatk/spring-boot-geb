package example.bank

import org.springframework.stereotype.Service

@Service('bankAccountService')
class BankAccountService {
    BankAccount getOrCreateAccount() {
        List<BankAccount> accounts = BankAccount.list()

        if (accounts) {
            return accounts[0]
        } else {
            return new BankAccount(balance: 0).save()
        }
    }

    BankAccount increaseBalance(BankAccount bankAccount, BigDecimal amount) {
        bankAccount.balance += amount
        bankAccount.save()

        return bankAccount
    }

    BankAccount decreaseBalance(BankAccount bankAccount, BigDecimal amount) {
        bankAccount.balance -= amount
        bankAccount.save()

        return bankAccount
    }
}
