package ssh_person.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class Person implements UserDetails{
        @Id
    @Column(name = "id",nullable = false,length = 32,unique = true)
    @GenericGenerator(name="generator",strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;
    private String name;
    private String idcard;
    private String phone;
    private String password;
//    @ManyToMany(cascade ={CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
//    private List<Role> roles;
//
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auths = new ArrayList<>();
//        List<Role> roles = this.getRoles();
//        for (Role role : roles) {
//            auths.add(new SimpleGrantedAuthority(role.getRole()));
//        }
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }
//    @Override
//    public String getPassword(){
//        return password;
//    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
