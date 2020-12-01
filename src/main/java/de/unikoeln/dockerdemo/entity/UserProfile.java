package de.unikoeln.dockerdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class UserProfile {
    @Id @GeneratedValue
    Long id;
    String name;
    String email;
    boolean active;
    boolean staff;

    public UserProfile(String name, String email, boolean active, boolean staff) {
        this.name = name;
        this.email = email;
        this.active = active;
        this.staff = staff;
    }
}
