package dev.login.loginApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "users")// lets the framework know that this class represents each document in the movies collection
@Data //takes care of all getters and setters
@AllArgsConstructor //for creating constructor that takes all the private fields as args
@NoArgsConstructor //constructor that takes no parameters
public class User {
    @Id //let framework know this should be treated as the unique identifier inside the database
    private ObjectId id;
    private String name;
    private String username;
    private String password;
    private Boolean manager;

    public User(String name, String username, String password, Boolean manager) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.manager = manager;
    }
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager){
        this.manager=manager;
    }
}
