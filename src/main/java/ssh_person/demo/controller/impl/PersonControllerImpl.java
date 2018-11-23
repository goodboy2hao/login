package ssh_person.demo.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssh_person.demo.entity.Person;
import ssh_person.demo.service.PersonService;

import java.util.List;

@RestController
//@RequestMapping(value = "/superadmin")
public class PersonControllerImpl{
@Autowired
private PersonService personService;
@RequestMapping(value = "/addPerson",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
    public boolean addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
    @RequestMapping(value = "/deletePerson",method = RequestMethod.POST)
    public boolean deletePerson(@RequestBody Integer id){
        return personService.deletePerson(id);
    }
    @RequestMapping(value = "/changePerson",method = RequestMethod.POST)
    public boolean changePerson(@RequestBody Person person){
        return personService.changePerson(person);
    }
    @RequestMapping(value = "/findPersonById",method = RequestMethod.POST)
    public Person findPersonById(@RequestBody Integer id){
        return personService.findPersonById(id);
    }
    @RequestMapping(value = "/findAllPerson",method = RequestMethod.GET)
    public List<Person> findAllPerson(){
        return personService.findAllPerson();
    }
}
