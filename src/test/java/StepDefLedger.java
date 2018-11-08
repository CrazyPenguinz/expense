//
//import cucumber.api.java.Before;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class StepDefLedger {
//
//    Ledger ledgerAccount;
//
//    @Before
//    public void init(){
//
//        ledgerAccount = new Ledger();
//    }
//
//    @Given("a user have balance (\\d+) exists")
//    public void a_user_have_balance_exists(int balance){
//        ledgerAccount = new Ledger(new Book(balance));
//
//    }
//
//    @When("I earned (\\d+) from (.*)")
//    public void i_earned_from(int income, String desc){
//        ledgerAccount.receive(desc, income);
//    }
//
//
//
//    @When("I spend (\\d+) for buy (.*)")
//    public void i_spend_for_buy(int expense, String desc) throws OverExpenseException{
//        ledgerAccount.pay(desc, expense);
//    }
//
//    @When("I spend (\\d+) over for buy (.*)")
//    public void i_spend_over_for_buy(int expense, String desc)throws OverExpenseException{
//        assertThrows(OverExpenseException.class,
//                () -> ledgerAccount.pay(desc, expense));
//    }
//
//    @Then("balance is (.*)")
//    public void balance_is_minus(int balance){
//        assertEquals(balance, ledgerAccount.getBalance());
//    }
//
//
//
//}
