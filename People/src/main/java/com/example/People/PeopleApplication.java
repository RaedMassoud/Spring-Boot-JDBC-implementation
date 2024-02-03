package com.example.People;

import com.example.People.model.Person;
import com.example.People.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PeopleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PeopleApplication.class, args);

		Person person = context.getBean(Person.class);
		person.setId(9);
		person.setFirstName("David");
		person.setLastName("Massoud");
		person.setCity("Achrafieh");

		// Instantiate DAO
		PersonRepository repo = context.getBean(PersonRepository.class);
		repo.save(person);


		System.out.println("All people: ");
		for(Person p : repo.getAll()) {
			System.out.println(p);
		}

		System.out.println("Ashrafieh people: ");
		for(Person p : repo.getByCity("Achrafieh")) {
			System.out.println(p);
		}


	}

}
