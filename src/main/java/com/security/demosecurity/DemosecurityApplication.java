package com.security.demosecurity;

import com.security.demosecurity.model.Employee;
import com.security.demosecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemosecurityApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;




    public static void main(String[] args) {
        SpringApplication.run(DemosecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee user=new Employee();
        user.setId(1);
        user.setUserId("user");

        user.setPassword(new BCryptPasswordEncoder().encode("12345"));
        userRepository.save(user);
        List<Employee> userList=userRepository.findAll();

        System.out.print(userList);

    }
}

