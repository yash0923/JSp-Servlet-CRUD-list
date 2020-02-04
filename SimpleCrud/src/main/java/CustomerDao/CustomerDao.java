package CustomerDao;

import java.util.List;

import CustomerBean.Customer;

public interface CustomerDao {
//	long saveCustomer(Customer customer);

//	void updateCustomer(Customer customer);

//	void deleteCustomer(Long id);

//	Customer findCustomerById(Long id);

	List<Customer> findAllCustomers();
}
