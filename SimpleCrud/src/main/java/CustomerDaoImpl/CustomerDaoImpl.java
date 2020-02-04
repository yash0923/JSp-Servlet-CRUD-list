package CustomerDaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import CustomerBean.Customer;
import CustomerDatabase.Database;
import CustomerDao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {
	private static CustomerDaoImpl customerDaoImpl = null;

	private Connection connection = Database.getConnection();

	
	

	

	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM customer_master.customer_master";
		List<Customer> customers = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);

			// Getting Customer's Detail
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				if (customers == null)
					customers = new ArrayList<>();

				Customer customer = new Customer();
				customer.setId(resultSet.getLong(1));
				customer.setFirstName(resultSet.getString(2));
				customer.setLastName(resultSet.getString(3));
				customer.setEmail(resultSet.getString(4));
				customer.setMobile(resultSet.getString(5));

				customers.add(customer);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return customers;
	}

	public static CustomerDao getInstance() {
		if (customerDaoImpl == null)
			customerDaoImpl = new CustomerDaoImpl();

		return customerDaoImpl;
	}
}
