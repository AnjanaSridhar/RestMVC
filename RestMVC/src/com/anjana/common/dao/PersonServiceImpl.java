package com.anjana.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anjana.common.model.Address;
import com.anjana.common.model.Person;
import com.anjana.common.model.PersonAndAddress;

public class PersonServiceImpl implements PersonService{

	private Connection connection;

	public PersonServiceImpl() {
		connection = DBUtility.getConnection();
	}
	String sql="";
	public PersonAndAddress getPersonById(int personId) {
		Person person = new Person();
		Address address = new Address();
		PersonAndAddress personAndAddress = new PersonAndAddress();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Person p LEFT OUTER JOIN address a on p.id = a.person_id where p.id = ?");
			preparedStatement.setInt(1, personId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				person.setPerson_id(rs.getInt("Id"));
				person.setName(rs.getString("Name"));
				person.setAge(rs.getInt("Age"));
				address.setHouse_number(rs.getInt("house_number"));
				address.setStreet_name(rs.getString("streetname"));
				address.setCity(rs.getString("city"));
				personAndAddress.setAddress(address);
				personAndAddress.setPerson(person);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personAndAddress;
	}

	public Address getAddressById(int personId) {
		Address address = new Address();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Address a where a.person_id = ?");
			preparedStatement.setInt(1, personId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				address.setHouse_number(rs.getInt("house_number"));
				address.setStreet_name(rs.getString("streetname"));
				address.setCity(rs.getString("city"));

			}
			return address;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();

		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Person");
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				Person person = new Person();
				person.setPerson_id(rs.getInt("Id"));
				person.setName(rs.getString("Name"));
				person.setAge(rs.getInt("Age"));
				people.add(person);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}

	public boolean addPerson(Person person) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			sql = "insert into Person(name, age) values(?,?)";
			PreparedStatement preparedStatement = connection.
					prepareStatement(sql);

			preparedStatement.setString(1, person.getName());
			preparedStatement.setInt(2, person.getAge());
			result = preparedStatement.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0){
			return true;
		}
		return false;

	}

	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			sql = "insert into Address(house_number, person_id, streetname, city) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.
					prepareStatement(sql);

			preparedStatement.setInt(1, address.getHouse_number());
			preparedStatement.setInt(2, address.getPerson_id());
			preparedStatement.setString(3,  address.getStreet_name());
			preparedStatement.setString(4,  address.getCity());
			result = preparedStatement.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0){
			return true;
		}
		return false;
	}
}
