package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Account implementation for commercial (business) customers.<br><br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account {
	private List<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		//AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit

		super(company,accountNumber,pin,startingDeposit);
		// complete the function
	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		// complete the function
		if(authorizedUsers == null){
			authorizedUsers = new ArrayList<>();
		}
		authorizedUsers.add(person);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		// complete the function
        return !(authorizedUsers.stream().filter(person1 -> person.getIdNumber() == person.getIdNumber()).count() == 0);
	}
}
