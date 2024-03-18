package com.jemutai.User.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Long id;

    private  String  name;

    @Column(name = "email",unique = true,length = 50)

    private  String email;

    private  int age;

    private  String occupation;
}
