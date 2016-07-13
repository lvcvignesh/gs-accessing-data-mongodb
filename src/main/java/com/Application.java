package com;

import com.cabcompany.entities.Customer;
import com.cabcompany.entities.Driver;
import com.cabcompany.repository.CustomerRepository;
import com.cabcompany.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private MongoTemplate template;
 	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        /*driverRepository.deleteAll();
        driverRepository.save(new Driver("Driver1", "Phoenix Marketcity, Chennai, Tamil Nadu", "Tata Indica", "TN01AA0001", "Mini"));
        driverRepository.save(new Driver("Driver2", "Guru Nanak Matriculation Higher Secondary School, Velachery, Anna Garden, Velachery, Chennai, Tamil Nadu 600042", "Tata Indica", "TN01AA0002", "Mini"));
        driverRepository.save(new Driver("Driver3", "Velachery Gate,IIT Madras,Chennai, Tamil Nadu", "Tata Indica", "TN01AA0003", "Mini"));
        driverRepository.save(new Driver("Driver4", "Gandhi Mandapam,Chennai 600042", "Tata Indica", "TN01AA0004", "Mini"));
        driverRepository.save(new Driver("Driver5", "Ceebros Heritage Apartments,Velachery,Chennai", "Tata Indica", "TN01AA0005", "Mini"));
        driverRepository.save(new Driver("Driver6", "Thiruvanmiyur MRTS Station,Chennai", "Tata Indica", "TN01AA0006", "Mini"));
        driverRepository.save(new Driver("Driver7", "PayPal IDC,Sholinganallur,Chennai, Tamil Nadu 600119", "Tata Indica", "TN01AA0007", "Mini"));
        driverRepository.save(new Driver("Driver8", "Double Roti,Chennai", "Tata Indica", "TN01AA0008", "Mini"));
        */
        customerRepository.deleteAll();
        customerRepository.save(new Customer("Customer1", "1111"));
        customerRepository.save(new Customer("Customer2", "1234"));
        customerRepository.save(new Customer("Customer3", "1235"));

    }

}
