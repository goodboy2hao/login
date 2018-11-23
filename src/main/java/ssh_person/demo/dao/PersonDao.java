package ssh_person.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ssh_person.demo.entity.Person;

import java.util.List;

public interface PersonDao extends JpaRepository<Person,Integer>{
    Person findByName(String name);
   List<Person> findByPhone(String phone);
   @Query(value = "select distinct phone from person",nativeQuery =true)
    List<String> phone();
}
