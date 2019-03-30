package com.jpj.enjoy.game.monitoring.controller;

import com.jpj.enjoy.game.monitoring.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//import com.grokonez.spring.restapi.mysql.repo.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController
{

	//	@Autowired
	//	CustomerRepository repository;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		System.out.println("Get all Customers...");

		List<Customer> customers = new ArrayList<>();
		//		repository.findAll().forEach(customers::add);

		return customers;
	}

	@PostMapping("/customer")
	public Customer postCustomer(@RequestBody Customer customer)
	{

		Customer _customer = new Customer();
		return _customer;
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id)
	{
		System.out.println("Delete Customer with ID = " + id + "...");

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@GetMapping("customers/age/{age}")
	public void findByAge(@PathVariable int age)
	{

	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer)
	{
		System.out.println("Update Customer with ID = " + id + "...");

		//		Optional<Customer> customerData = repository.findById(id);
		//
		//		if (customerData.isPresent()) {
		//			Customer _customer = customerData.get();
		//			_customer.setName(customer.getName());
		//			_customer.setAge(customer.getAge());
		//			_customer.setActive(customer.isActive());
		//			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		//		} else {
		//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
