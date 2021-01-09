package prac.functional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FunctionalProgramming {

	/*
	 * public void test() { int count=0; new Thread(()->{ System.out.println("Hi");
	 * }); }
	 */

	public static void main(String[] args) throws IOException {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Suhail", "Mansoori", 18));
		persons.add(new Person("David", "Romania", 15));
		persons.add(new Person("Backham", "Procos", 35));
		persons.add(new Person("Winter", "Singer", 40));
		persons.add(new Person("Abraham", "Linkon", 33));
		persons.add(new Person("Cotlin", "Adrew", 55));

		persons.stream().sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
				.forEach(p -> System.out.println(p.getLastName()));

		IntStream.range(1, 10).forEach(i -> System.out.println(i));

		System.out.println(IntStream.range(1, 8).sum());
		
		System.out.println(persons.stream().map(Person::getAge).reduce(0, (a,b)->a+b));

		// readFromFile();

	}

	/*
	 * private static void readFromFile() throws IOException { List<String> lines =
	 * Files.lines(Paths.get("data.txt")).filter(line -> line.startsWith("B"))
	 * .collect(Collectors.toList()); lines.stream().forEach(line ->
	 * System.out.println(line)); }
	 */

}

class Person {
	String firstName;
	String lastName;
	int age;

	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}