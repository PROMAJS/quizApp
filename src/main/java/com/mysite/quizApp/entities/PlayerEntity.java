package com.mysite.quizApp.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity (name = "PLAYERS")
@NoArgsConstructor
@ToString
@Getter
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    public String name;

    public PlayerEntity(String name) {
        this.name = name;
    }





}
