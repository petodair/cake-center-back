package br.com.cake_center_back.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@ToString
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Product> products = new ArrayList<>();
}
