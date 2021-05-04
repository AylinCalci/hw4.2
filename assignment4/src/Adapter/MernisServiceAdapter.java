package Adapter;

import java.rmi.RemoteException;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean isRealPerson(Customer customer) {

		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();

		boolean result = false;

		try {
			result = proxy.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),
					customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), 2000);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}

		return result;

	}

}