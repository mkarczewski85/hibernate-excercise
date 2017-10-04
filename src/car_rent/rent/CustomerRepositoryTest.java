package car_rent.rent;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CustomerRepositoryTest {
    @Test
    public void findByEmail() throws Exception {


        Optional<Customer> byEmail = CustomerRepository.findByEmail("test@gmail.com");
        Assert.assertTrue("Should return user by email", byEmail.isPresent());

    }

    @Test
    public void update() throws Exception {

        Optional<Customer> byEmail = CustomerRepository.findByEmail("test@gmail.com");
        if (byEmail.isPresent()) {
            Customer customer = byEmail.get();
            customer.setPhoneNumber("666666");
            Assert.assertTrue(CustomerRepository.update(customer));

            Customer customerEdit = CustomerRepository.findByEmail("test@gmail.com").get();
            Assert.assertTrue("should return phone number", customerEdit.getPhoneNumber()
                    .equals(customer.getPhoneNumber()));
        }


    }

}