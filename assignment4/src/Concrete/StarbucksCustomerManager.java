package Concrete;

import Abstract.CustomerCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager implements CustomerCheckService {

	private CustomerCheckService checkService;

	public StarbucksCustomerManager(CustomerCheckService checkService) {
		this.checkService = checkService;
	}

	@Override
	public void add(Customer customer) {

		if (checkService.isRealPerson(customer)) {
			System.out.println("Veritaban�na eklendi : " + customer.getFirstName());
		}else {
			System.out.println("Ekleme Yap�lamad�.");
		}

	}

	@Override
	public boolean isRealPerson(Customer customer) {
		
		return false;
	}
}