package com.anjana.common.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anjana.common.dao.PersonService;
import com.anjana.common.dao.PersonServiceImpl;
import com.anjana.common.model.Address;
import com.anjana.common.model.Person;
import com.anjana.common.model.PersonAndAddress;

@Controller

public class TestController {

	PersonService personService = new PersonServiceImpl();


	@RequestMapping(value="/getPeople", method = RequestMethod.GET)
	public ModelAndView getPeople() {
		List<Person> people=personService.getPeople();
		return new ModelAndView("showPeople", "people", people);
	}

	@ModelAttribute("person")
	public Person loadEmptyModelBean(){
		return new Person();
	}

	@RequestMapping(value="/addPerson", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("person")Person person, ModelMap model) {
		String msg = "";
		boolean result = personService.addPerson(person);
		if(result==true){
			msg = "Person was added successfully. You can add another one or click on ";
			model.addAttribute("person",new Person());
			return new ModelAndView("AddPerson", "msg", msg);
		} else {
			msg = "An error occurred. Could not add person";
			return new ModelAndView("AddPerson", "msg", msg);
		}

	}

	@RequestMapping(value="/add_person", method = RequestMethod.GET)

	public String navigateToAddPerson(ModelMap model) {
		return "AddPerson";
	}

	@RequestMapping(value="/add_address/{id}", method = RequestMethod.GET)

	public ModelAndView navigateToAddress(@PathVariable int id) {
		Address address;
		address=personService.getAddressById(id);
		if(address == null)
		{
			address = new Address();
			address.setPerson_id(id);
		}
		address.setPerson_id(id);
		return new ModelAndView("AddAddress", "address", address);
	}
	@RequestMapping(value="/get_person/{id}", method = RequestMethod.GET)

	public ModelAndView navigateToPerson(@PathVariable int id) {
		PersonAndAddress personAndAddress=personService.getPersonById(id);
		return new ModelAndView("ShowPerson", "personAndAddress", personAndAddress);
	}

	@RequestMapping(value="/addAddress", method = RequestMethod.POST)
	public ModelAndView addAddress(@ModelAttribute("address")Address address, ModelMap model) {
		String msg = "";
		boolean result = personService.addAddress(address);
		if(result==true){
			msg = "Address was added successfully. click on ";
			return new ModelAndView("AddAddress", "msg", msg);
		} else {
			msg = "An error occurred. Could not add address";
			return new ModelAndView("AddAddress", "msg", msg);
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView root() {
		List<Person> people=personService.getPeople();
		return new ModelAndView("Index", "people", people);
	}



}
