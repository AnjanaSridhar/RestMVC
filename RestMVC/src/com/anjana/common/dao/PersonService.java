package com.anjana.common.dao;

import java.util.List;

import com.anjana.common.model.Address;
import com.anjana.common.model.Person;
import com.anjana.common.model.PersonAndAddress;

public interface PersonService {

	public PersonAndAddress getPersonById(int personId);

	public Address getAddressById(int personId);

	public List<Person> getPeople();

	public boolean addPerson(Person person);

	public boolean addAddress(Address address);

}
