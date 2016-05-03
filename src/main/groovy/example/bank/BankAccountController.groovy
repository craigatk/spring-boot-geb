package example.bank

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/bank")
class BankAccountController {
    BankAccountService bankAccountService

    @Autowired
    BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService
    }

    @RequestMapping("/account")
    String account(Model model) {
        BankAccount account = bankAccountService.getOrCreateAccount()

        model.addAttribute('accountBalance', account.balance)

        return 'account'
    }

    @RequestMapping(value="/deposit", method=RequestMethod.POST)
    String deposit(BigDecimal amount, Model model) {
        BankAccount account = bankAccountService.getOrCreateAccount()

        account = bankAccountService.increaseBalance(account, amount)

        model.addAttribute('accountBalance', account.balance)
        model.addAttribute('depositAmount', amount)

        return 'deposit'
    }
}
