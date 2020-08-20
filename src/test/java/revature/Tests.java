package revature;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import com.revature.daos.AccountDAO;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountServices;
import com.revature.utils.ConsoleUtil;

public class Tests {
	public static int intResult;
	public static Account account; 
	public static Account account2; 
	public static double amount;

	public static User user; 
	
	private AccountServices as= new AccountServices();
	
	private AccountDAO ad = new AccountDAO();
	
	ConsoleUtil cons = new ConsoleUtil();
	
//	@BeforeClass
//	public void setUserAccounts() {
//		
//	}
	
	@Before
	public void setUp() {	
		amount=100;
		user= new User("Customer","testFirst", "testLast","testPhone", "testUsername");
		//us.insertUser(user);
		//already inserted
		account = new Account(6779,23.5,876868680, "valid", user);
		as.addAccount(account);
//		/public Account(int account_number, double account_balance, String account_status)
		//as.insertAccount(account2);
	}

	
//	@Test
	public void testWithdraw() {
	//	Account a= account;
		System.out.println("Testing withdraw");
		as.withdraw(account, amount);
		double accountBalance= ad.findById(29).getAccount_balance();
		assertTrue(accountBalance==0);
	}
}
	
//}
//}
