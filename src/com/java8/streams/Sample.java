package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Sample {

	public static void main(String[] args) {
		List<Person> people = createPeople();
		
		// get, in uppercase, the names of all female older than 18
		List<String> names = new ArrayList<>();
		for (Person person : people) {
			if (person.getGender() == Gender.FEMALE && person.getAge() > 18) {
				names.add(person.getName().toUpperCase());
			}
		}
		System.out.println(names);
		
		System.out.println(
			people.stream()
				.filter(person -> person.getGender() == Gender.FEMALE)
				.filter(person -> person.getAge() > 18)
				.map(person -> person.getName().toUpperCase())
				.collect(toList())
		);
		
		people.stream()
			.filter(person -> person.getGender() == Gender.MALE)
			.map(person -> new Person(person.getName().toUpperCase(), person.getGender(), person.getAge()))
			.forEach(System.out::println);
		
		System.out.println(
			people.stream()
				.map(Person::getAge)
				.reduce(0, Integer::sum)
				//.reduce(0, (carry, age) -> carry + age)
		);
		
		System.out.println(
			people.stream()
				.min((person1, person2) -> person1.getAge() > person2.getAge() ? 1 : -1)	
		);
		
		System.out.println(
			people.stream()
				.filter(person -> person.getAge() < 18)
				.count()
		);
		
		// don't do this
		// causes side-effect, interfering, mutating, ugly, smelly, dangerous, can't make this concurrent.
		List<String> nameList = new ArrayList<>();
		people.stream()
			.filter(person -> person.getAge() > 17)
			.map(Person::getName)
			.map(String::toUpperCase)
			//this is bad idea
			.forEach(nameList::add);
		System.out.println(nameList);
		
		//how to fix the above issue ?
	    //Smelly, but illustrates some essential points.
	    /*
	     The collect takes three parameters:
	       1. Supplier - the initial value for the reduction
	       2. The accumulator - this takes an element and accumulates to the evolving result
	       3. The combiner - this is useful during parallel execution, this can take two partial results and combine into one.
	    */		
		List<String> nameList2 = people.stream()
			.filter(person -> person.getAge() > 17)
			.map(Person::getName)
			.map(String::toUpperCase)
			.collect(
                () -> new ArrayList<String>(),
                (list, name) -> list.add(name),
                (list1, list2) -> list1.addAll(list2)
//				toList()
			);
		System.out.println(nameList2);		
		
		Set<String> males = people.stream()
				.filter(person -> person.getGender() == Gender.MALE)
				.map(Person::getName)
				.collect(toSet());
		System.out.println(males);
		
		Map<String, Person> map = people.stream().collect(toMap(
				person -> person.getName() + ":" + person.getAge(), 
				person -> person));
		System.out.println(map);
		
		Map<String, List<Person>> map2 = people.stream().collect(groupingBy(Person::getName));
		map2.forEach((k, v) -> 
			System.out.println(k + " -- " + v)
		);
		
		//find the first person whose name is four letters but is older than 25
		System.out.println(
			people.stream()
				.filter(Sample::is4letters)
				.filter(person -> person.getAge() > 25)
				.findFirst());
		
		//infinite collection
		Stream.iterate(1,  e -> e + 1)
			.filter(e -> e % 2 ==0)
			.limit(10)
			.forEach(System.out::println);
		
		
	}
	
	public static boolean is4letters(Person person) {
		System.out.println("Called for " + person);
		return person.getName().length() == 4;
	}

	public static List<Person> createPeople() {
		return Arrays.asList(new Person("Sara", Gender.FEMALE, 20), new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20), new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32), new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 72), new Person("Jill", Gender.FEMALE, 12));
	}
}
