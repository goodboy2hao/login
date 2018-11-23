package ssh_person.demo.service;

import org.springframework.stereotype.Service;
import ssh_person.demo.entity.Person;

import java.util.List;
@Service
public interface PersonService {
    public boolean addPerson(Person person);
    public boolean deletePerson(Integer id);
    public boolean changePerson(Person person);
    public Person findPersonById(Integer id);
    public List<Person> findAllPerson();
}
