package org.fun.office;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.*;
import static org.fun.office.Department.*;
import static org.fun.office.Gender.FEMALE;
import static org.fun.office.Gender.MALE;

public class Employee {

	int id;
	String firstName;
	String lastName;
	Gender gender;
	LocalDate dateOfJoining;
	Department department;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public Department getDepartment() {
		return department;
	}

	public Employee() {}

	public Employee(int id, String firstName, String lastName, Gender gender, LocalDate dateOfJoining, Department
			department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
		this.department = department;
	}

	@Override
	public String toString() {
		return getFullName();
	}

	public String getYearsInADPText() {
		Period p = Period.between(dateOfJoining, LocalDate.now());
		return p.getYears() + "." + p.getMonths() + " years";
	}

	public double getYearsInADP() {
		Period p = Period.between(dateOfJoining, LocalDate.now());
		return p.getYears() + p.getMonths() / 12d;
	}

	public String fullDetails() {
		return id +
				": " + firstName + ' ' + lastName +
				" (" + gender +
				"), JoinedOn: " + dateOfJoining +
				", Department: " + department;
	}

	private static List<Employee> members = new ArrayList<>();
	static {
		addEmployee(10001, MALE, "John", "Travolta", 2001, APRIL, 2, Technology);
		addEmployee(10002, MALE, "Tom", "Cruise", 2002, MARCH, 14, Admin);
		addEmployee(10003, MALE, "Brad", "Pitt", 2003, APRIL, 25, Finance);
		addEmployee(10004, MALE, "Tom", "Hanks", 2004, JULY, 18, HR);
		addEmployee(10005, MALE, "Will", "Smith", 2005, OCTOBER, 3, Admin);
		addEmployee(10020, FEMALE, "Julia", "Roberts", 2009, JUNE, 2, Finance);
		addEmployee(10021, FEMALE, "Angelina", "Jolie", 2012, JUNE, 30, BPO);
		addEmployee(10022, FEMALE, "Meg", "Ryan", 2014, JULY, 7, Technology);
	}

	public static List<Employee> getEmployees() {
		return members;
	}

	private static void addEmployee(int id, Gender gender, String name, String lastName,
									int year, Month month, int day, Department department) {
		members.add(new Employee(id, name, lastName, gender, LocalDate.of(year, month, day), department));
	}

}
