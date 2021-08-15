package com.xworkz.customer.tester;

import com.xworkz.customer.constant.Education;
import com.xworkz.customer.dto.CustomerDTO;
import com.xworkz.customer.service.CustomerService;
import com.xworkz.customer.service.CustomerServiceImpl;

public class CustomerSaveTester {

	public static void main(String[] args) {

		CustomerService service = new CustomerServiceImpl();
		CustomerDTO dto1 = new CustomerDTO("Pavan", "Chennai", "Paris", "Thangavel street, Hindipur", false,
				143143143, Education.BE);
		CustomerDTO dto2 = new CustomerDTO("Harsha", "Vizag", "Delhi", "Venugopal nagar, Anantapur", false,
				143143142, Education.BE);
		CustomerDTO dto3 = new CustomerDTO("Bhanu", "Bangalore", "Vijayawada", "RK nagar, Anantapur", false, 143143141,
				Education.BE);
		CustomerDTO dto4 = new CustomerDTO("Hema", "Mangalore", "Chennai", "Arch Gate, Anantapur", true, 143143144,
				Education.ME);
		CustomerDTO dto5 = new CustomerDTO("Nawaz", "Bangalore", "Goa", "Gorimedu, Anantapur", false, 143143145, Education.MBA);


		service.validateAndSave(dto1);
		service.validateAndSave(dto2);
		service.validateAndSave(dto3);
		service.validateAndSave(dto4);
		service.validateAndSave(dto5);
	}

}
