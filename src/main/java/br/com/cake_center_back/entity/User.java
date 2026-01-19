package br.com.cake_center_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
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

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Product> products = new ArrayList<>();


    public User(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
