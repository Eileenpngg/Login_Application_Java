package dev.login.loginApplication.users;

import lombok.AllArgsConstructor;
import lombok.Builder; //helps build the user object using the design pattern builder
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection= "users")// lets the framework know that this class represents each document in the movies collection
@Data//takes care of all getters and setters
@Builder
@AllArgsConstructor //for creating constructor that takes all the private fields as args
@NoArgsConstructor //constructor that takes no parameters
public class User implements UserDetails {
    @Id //let framework know this should be treated as the unique identifier inside the database
    private ObjectId id;
    private String name;
    private String username;
    private String password;
    private Role role;

    @Override //getAuthorities needs a collection of granted authorities, roles
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name())); //we decided user can can only have one role
    }
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

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}



//account non expired,  if you want to have an expiring user, log out user