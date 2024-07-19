package com.example.OnetoOne_Example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository erepo;
	@Autowired
	AddressRepository arepo;
	@RequestMapping ("/hello")
	public String hello()
	{
		return " this is employee test";
				
	}
	@RequestMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee emp)
	{
//		Employee e=new Employee();
//		Address a=new Address();
//		a.setAstreet("kutchery");
//		a.setAcity("lalpur");
//		e.setEname("tania prasad");
//		e.setAddress(a);
//		e.setEage(20);
//		a.setEmployee(e);
	 //   Address saveAddress=arepo.save(emp.getAddress());
		emp.getAddress().setEmployee(emp);
		Employee saveuser=erepo.save(emp);
		return ResponseEntity.ok(saveuser); // bidirectional 
	}
	@RequestMapping("/all")
	public List<Employee>all()
	{
		return erepo.findAll();
	}
	@RequestMapping("/{id}")
	public Optional<Employee> byid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	@RequestMapping("del/{id}")
	public String delete(@PathVariable int id)
	{
		erepo.deleteById(id);
		return "emp deleted";
	}
	@RequestMapping("/alldata")
	public List<Address>byaddress() // Address repo is used i.e, bidirectional
	{
		return arepo.findAll();
	}  
	// As this is bidirectional any repo can be used
	
	@RequestMapping("/acity/{acity}")
	public List<Address>bycity(@PathVariable String acity)
	{
		return arepo.findByAcity(acity);
	}
	@RequestMapping("/ename/{ename}")
	public List<Employee>byname(@PathVariable String ename)
	{
		return erepo.findByEname(ename);
	}
}
