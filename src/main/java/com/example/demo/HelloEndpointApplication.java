package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@SpringBootApplication
@RestController
public class HelloEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloEndpointApplication.class, args);
	}
	
	@GetMapping
	public String status() throws UnknownHostException {
		return "status-up"+InetAddress.getLocalHost().toString();
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> list = Stream.of(
				new Employee("1","soham","soham@email.com"),
				new Employee("2","anjali","anjali@email.com"),
				new Employee("3","arundhuti","arundhuti@email.com")
				).collect(Collectors.toList());
		return list;
	}

}
