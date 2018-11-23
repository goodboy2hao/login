package ssh_person.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ssh_person.demo.entity.Person;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;
    @Test
    public void findByName() throws Exception {
        Person person=personDao.findByName("admin");
        System.out.println(person.getName());
    }
    @Test
    public void phone() throws Exception {
        List<String> phones=personDao.phone();
        String d="";
    }
//    @Test
//    public void findByName() {
//        Person person=personDao.findByName("admin");
//        System.out.println(person.getName());
//    }

}