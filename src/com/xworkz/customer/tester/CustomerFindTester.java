package com.xworkz.customer.tester;

import java.util.Collection;
import java.util.Optional;

import com.xworkz.customer.dto.CustomerDTO;
import com.xworkz.customer.service.CustomerService;
import com.xworkz.customer.service.CustomerServiceImpl;

public class CustomerFindTester {

	public static void main(String[] args) {

		CustomerService service = new CustomerServiceImpl();

		Collection<CustomerDTO> collection = service.findAll();
		collection.forEach(r -> System.out.println(r));

		collection = service.findAll((a) -> a.getTo().equals("Bangalore"));
		collection.forEach(r -> System.out.println(r));

		collection = service.findAllSortByNameDesc();
		collection.forEach(r -> System.out.println(r));

		Optional<CustomerDTO> opt = service.findOne((a) -> a.getName().equals("Harsha"));
		if (opt.isPresent()) {
			CustomerDTO dto = opt.get();
			System.out.println(dto);
		}

		System.out.println(service.total());

	}

}
