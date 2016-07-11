package com;

import com.cabcompany.entities.Driver;
import com.cabcompany.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private DriverRepository repository;
    @Autowired
    private MongoTemplate template;
 	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
 /*       repository.deleteAll();
        repository.save(new Driver("Driver1","Phoenix Marketcity, Chennai, Tamil Nadu","Tata Indica","TN01AA0001","Mini"));
        repository.save(new Driver("Driver2","Guru Nanak Matriculation Higher Secondary School, Velachery, Anna Garden, Velachery, Chennai, Tamil Nadu 600042","Tata Indica","TN01AA0002","Mini"));
        repository.save(new Driver("Driver3","Velachery Gate,IIT Madras,Chennai, Tamil Nadu","Tata Indica","TN01AA0003","Mini"));
        repository.save(new Driver("Driver4","Gandhi Mandapam,Chennai 600042","Tata Indica","TN01AA0004","Mini"));
        repository.save(new Driver("Driver5","Ceebros Heritage Apartments,Velachery,Chennai","Tata Indica","TN01AA0005","Mini"));
        repository.save(new Driver("Driver6","Thiruvanmiyur MRTS Station,Chennai","Tata Indica","TN01AA0006","Mini"));
        repository.save(new Driver("Driver7","PayPal IDC,Sholinganallur,Chennai, Tamil Nadu 600119","Tata Indica","TN01AA0007","Mini"));
        repository.save(new Driver("Driver8","Double Roti,Chennai","Tata Indica","TN01AA0008","Mini"));
*/
        Driver driver;
        driver=repository.findByname("Driver3");
        Point p=new Point(driver.getCurrentLocation().getX(),driver.getCurrentLocation().getY());
        Circle circle=new Circle(p,new Distance(1700/6371000));
        for(Driver iter:repository.findByCurrentLocationWithin(circle))
        {
            System.out.println(iter);
        }

        /*List<Driver> drivers= repository.findByCurrentLocationNear(driver.getCurrentLocation(),new Distance(10,Metrics.KILOMETERS));
        for(Driver iter:drivers)
        {
            System.out.println(iter);
        }*/
	}

}
