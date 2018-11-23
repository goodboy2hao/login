package ssh_person.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssh_person.demo.dao.PersonDao;
import ssh_person.demo.entity.Person;
import ssh_person.demo.service.PersonService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PersonSerciceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Override
    public boolean addPerson(Person person) {
        if(person!=null){
            String password=new BCryptPasswordEncoder().encode(person.getPassword());
            person.setPassword(password);
            personDao.save(person);
            return true;
        }else
            return false;
    }

    @Override
    public boolean deletePerson(Integer id) {
        if(id!=null&&personDao.existsById(id)){
            personDao.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public boolean changePerson(Person person) {
        if(person!=null&&person.getId()!=null&&personDao.existsById(person.getId())){
            personDao.save(person);
            return true;
        }else
            return false;
    }

    @Override
    public Person findPersonById(Integer id) {
        if(id!=null&&personDao.existsById(id)){
            return personDao.getOne(id);
        }else
            return null;
    }
    @Override
    public List<Person> findAllPerson() {
        List<Person>personList=personDao.findAll();
        if(!personList.isEmpty()){
            return personList;
        }else
            return null;
    }
    @Transactional
    @PostConstruct
    public void init() throws Exception {
        System.out.println("JavaBean类init 方法");
        List<Person> list = personDao.findAll();
        if(list.size() <= 0){
           Person person=new Person();
            person.setName("admin");
            String password = new BCryptPasswordEncoder().encode("123456");
            person.setPassword(password);
            personDao.save(person);
        }
    }


}
