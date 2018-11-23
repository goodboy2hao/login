package ssh_person.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ssh_person.demo.dao.PersonDao;
import ssh_person.demo.entity.Person;

public class SecurityService implements UserDetailsService {
    @Autowired
    private PersonDao personDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       if(s!=null){
           Person person=personDao.findByName(s);
           if(person==null)
               throw new UsernameNotFoundException("用户名不存在");
           else {
               System.out.println("s:" + s);
               System.out.println("username:" + person.getUsername());
               return person;
           }
       }else
           return null;
    }
}
