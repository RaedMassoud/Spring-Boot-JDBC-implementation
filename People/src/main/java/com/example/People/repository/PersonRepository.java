package com.example.People.repository;

import com.example.People.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Similar to @Component
public class PersonRepository {
    // This class is responsible for database communication

    // Jdbc template with getter and setter
    private JdbcTemplate template;
    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired // Injected
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // add to table
    public void save(Person person) {
        String sql = "insert into person (id, first_name, last_name, city) values (?,?,?,?)";
        template.update(sql, person.getId(), person.getFirstName(), person.getLastName(), person.getCity());
    }

    // return list of all people
    public List<Person> getAll() {
        String sql = "Select * from person";
        RowMapper<Person> mapper = (rs, rowNum) -> {
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setFirstName(rs.getString(2));
                person.setLastName(rs.getString(3));
                person.setCity(rs.getString(4));

                return person;
        };
        List<Person> people = template.query(sql, mapper);
        return people;
    }

    // return list of achrafieh people
    public List<Person> getByCity(String city) {
        String sql = "Select * from person where city=?";
        RowMapper<Person> mapper = (rs, rowNum) -> {
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setFirstName(rs.getString(2));
                person.setLastName(rs.getString(3));
                person.setCity(rs.getString(4));
                return person;
        };
        List<Person> people = template.query(sql, mapper, city);
        return people;
    }

    // delete by name
    public void delete(String firstName) {
        String sql = "Delete from person where first_name=?";
        template.update(sql, firstName);
    }

}
