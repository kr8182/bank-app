package ru.kr8182.bankapp.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Table(name = "client")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor

    public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String dateOfBirth;

        @Column(nullable = false)
        private String DPAN;

    }

