package ssh_person.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ssh_person.demo.entity.Person;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonSerciceImplTest {
    @Autowired
    PersonSerciceImpl personSercice;
    @Test
    public void addPerson() throws Exception {
        Person person=new Person();
        person.setIdcard("adfsd");
        person.setName("psadf");
        personSercice.addPerson(person);
        String adgf="";
    }

    @Test
    public void deletePerson() throws Exception {
    }

    @Test
    public void changePerson() throws Exception {
    }

    @Test
    public void findPersonById() throws Exception {
    }

    @Test
    public void findAllPerson() throws Exception {
    }

}