package prac.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class FunctionalProgramming {
	
	/*
	 * public void test() { int count=0; new Thread(()->{ System.out.println("Hi");
	 * }); }
	 */

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Suhail", "Mansoori"));
		persons.add(new Person("David", "Romania"));
		persons.add(new Person("Backham", "Procos"));
		persons.add(new Person("Winter", "Singer"));
		persons.add(new Person("Abraham", "Linkon"));
		persons.add(new Person("Cotlin", "Adrew"));

		persons.stream().sorted((a, b) -> a.getLastName().compareTo(b.getLastName())).
		forEach(p->System.out.println(p.getLastName()));
		
		
		IntStream.range(1, 10).forEach(i->System.out.println(i));
		

	}

}

class Person {
	String firstName;
	String lastName;

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}