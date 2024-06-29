package ironhack.schl.Lab3._4.repository;

import ironhack.schl.LabThreeDotZeroFourApplication;
import ironhack.schl.Model.Customer;
import ironhack.schl.Model.CustomerStatus;
import ironhack.schl.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LabThreeDotZeroFourApplication.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer testCustomer;

    @BeforeEach
    public void setUp() {
        testCustomer = new Customer("John Doe", CustomerStatus.SILVER, 10000);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteById(testCustomer.getCustomerId());
    }

    @Test
    public void testCreateCustomer() {
        Customer savedCustomer = customerRepository.save(testCustomer);
        assertNotNull(savedCustomer.getCustomerId());
        assertEquals(testCustomer.getCustomerName(), savedCustomer.getCustomerName());
        assertEquals(testCustomer.getTotalCustomerMileage(), savedCustomer.getTotalCustomerMileage());
    }

    @Test
    public void testFindCustomersByName() {
        Customer savedCustomer = customerRepository.save(testCustomer);
        List<Customer> customersByName = customerRepository.findByCustomersName(testCustomer.getCustomerName());
        assertTrue(customersByName.contains(savedCustomer));
    }

    @Test
    public void testFindCustomersByStatus() {
        Customer savedCustomer = customerRepository.save(testCustomer);
        List<Customer> customersByStatus = customerRepository.findByCustomersStatus(testCustomer.getCustomerStatus());
        assertTrue(customersByStatus.contains(savedCustomer));
    }
}