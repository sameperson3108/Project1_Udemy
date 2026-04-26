package dao;

import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> show (String email) {
        return jdbcTemplate.query("SELECT * FROM person WHERE email=?", new Object[] {email},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person show (int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(surname, name, patonymic, birthYear) values(?,?,?,?)",
                person.getSurname(), person.getName(), person.getPatonymic(), person.getBirthYear());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET surname=?, name=?, patonymic=?, birthYear=? WHERE id=?)",
        updatedPerson.getSurname(), updatedPerson.getName(), updatedPerson.getPatonymic(), updatedPerson.getBirthYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }

}
