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
		CustomerDTO dto1 = new CustomerDTO("Bhanu", "Vizag", "Paris", "Thangavel street, Vizag", false,
				123456781, Education.BE);
		CustomerDTO dto2 = new CustomerDTO("Harsha", "Ananthapur", "Goa", "Venugopal nagar, Ananthapur", false,
				123456782, Education.BE);
		CustomerDTO dto3 = new CustomerDTO("Pavan", "Bangalore", "Hyderabad", "RK nagar, Tumkur", false,
				123456783, Education.BE);
		CustomerDTO dto4 = new CustomerDTO("Aravind", "Hindupur", "Chennai", "Arch Gate, Hindupur", false,
				123456784, Education.ME);
		CustomerDTO dto5 = new CustomerDTO("Hema", "Anantapur", "Goa", "Gorimedu, Anantapur", false,
				123456785, Education.MBA);
		
		Collection<CustomerDTO> collection = Arrays.asList(dto1, dto2, dto3, dto4, dto5);
		service.ValidateAndSaveAll(collection);

	}

}