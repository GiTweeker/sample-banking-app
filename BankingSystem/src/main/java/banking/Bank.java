package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
		if(accounts == null){
			accounts = new LinkedHashMap<>();
		}
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		if(accounts == null){
			accounts = new LinkedHashMap<>();
		}
		Long accountNumber  = (long) (accounts.size() + 1);
		CommercialAccount mAccount = new CommercialAccount(

				company,
				accountNumber
				,
				pin,startingDeposit);

		accounts.put(accountNumber,mAccount);
        return

				accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		if(accounts == null){
			accounts = new LinkedHashMap<>();
		}
		Long accountNumber  = (long) (accounts.size() + 1);
		ConsumerAccount mAccount = new ConsumerAccount(

				person,
				accountNumber
				,
				pin,startingDeposit);

		accounts.put(accountNumber,mAccount);
		return

				accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		if(this.accounts.containsKey(accountNumber)){

			return this.accounts.get(accountNumber).validatePin(pin);
		}
        return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		if(this.accounts.containsKey(accountNumber)){

			return this.accounts.get(accountNumber).getBalance();
		}
        return -1;
	}

	public void credit(Long accountNumber, double amount) {
		if(this.accounts.containsKey(accountNumber)){

			 this.accounts.get(accountNumber).creditAccount(amount);
		}

	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		if(this.accounts.containsKey(accountNumber)){

			return this.accounts.get(accountNumber).debitAccount(amount);
		}
        return false;
	}
}
