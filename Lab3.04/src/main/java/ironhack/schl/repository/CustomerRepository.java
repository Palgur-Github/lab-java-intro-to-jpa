package ironhack.schl.repository;

import ironhack.schl.Model.Customer;
import ironhack.schl.Model.CustomerStatus;
import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    List<Customer> findCustomersByName(String customerName);

    List<Customer> findCustomersByStatus(CustomerStatus customerStatus);
}
