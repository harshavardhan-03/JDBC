package com.xworkz.customer.tester;

import java.util.Arrays;
import java.util.Collection;

import com.xworkz.customer.constant.Education;
import com.xworkz.customer.dto.CustomerDTO;
import com.xworkz.customer.service.CustomerService;
import com.xworkz.customer.service.CustomerServiceImpl;

public class CustomerSaveAllTester {

	public static void main(String[] args) {

		CustomerService service = new CustomerServiceImpl();
		CustomerDTO dto1 = new CustomerDTO("Pavan", "Chennai", "Paris", "Thangavel street, Hindipur", false,
				123456781, Education.BE);
		CustomerDTO dto2 = new CustomerDTO("Harsha", "Vizag", "Delhi", "Venugopal nagar, Anantapur", false,
				123456782, Education.BE);
		CustomerDTO dto3 = new CustomerDTO("Bhanu", "Bangalore", "Vijayawada", "RK nagar, Anantapur", false, 123456783,
				Education.BE);
		CustomerDTO dto4 = new CustomerDTO("Hema", "Mangalore", "Chennai", "Arch Gate, Anantapur", true, 123456784,
				Education.ME);
		CustomerDTO dto5 = new CustomerDTO("Nawaz", "Bangalore", "Goa", "Gorimedu, Anantapur", false, 123456785, Education.MBA);

		Collection<CustomerDTO> collection = Arrays.asList(dto1, dto2, dto3, dto4, dto5);
		service.ValidateAndSaveAll(collection);
		collection.forEach(r -> System.out.println(r));

	}

}