package com.example.employeeservice;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories
public class EmployeeServiceApplication implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAll();

        String orgId1 = "65e76fbf-6e03-4298-a644-6db769a9436c";
        String orgId2 = "8acf038f-8617-46ab-824e-54801d07a53b";
        String financeId = "eccc57b5-df61-4926-bdf3-64326d63bf89";
        String hrId = "42fbb131-f315-42be-96c3-a76461a82897";
        String salesId = "539fa5da-d293-4ef7-8146-6112b8b438a3";
        String engineeringId = "0b35362e-87c3-4b17-ba3d-e92465579346";

        Employee john = new Employee(orgId1, financeId, "John Doe", 35, "Manager");
        Employee jane = new Employee(orgId1, hrId, "Jane Doe", 33, "Director");
        Employee jill = new Employee(orgId2, salesId, "Jill Doe", 33, "Consultant");
        Employee jack = new Employee(orgId2, engineeringId, "Jack Doe", 33, "Vice President");

        employeeRepository.save(john);
        employeeRepository.save(jane);
        employeeRepository.save(jill);
        employeeRepository.save(jack);
    }
}
