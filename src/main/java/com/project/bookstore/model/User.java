package com.project.bookstore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_user;
    @Column(name = "nume", nullable = false, length = 20)
    private String nume;
    @Column(name = "prenume", nullable = false, length = 20)
    private String prenume;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;
    @Column(nullable = false, length = 64)
    private String password;
    @Column(name = "role", nullable = false, length = 20)
    private String role;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name="id_user"),
//    inverseJoinColumns = @JoinColumn(name = "id_role"))
//    private Set<Role> roles = new HashSet<>();

    public User(Long id_user, String nume, String prenume, String email, String username, String password, String role) {
        this.id_user = id_user;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /*public User(UserBuilder builder)
    {
        this.id_user = builder.id_user;
        this.nume = builder.nume;
        this.prenume = builder.prenume;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
    }*/

    public User()
    {

    }

    /*public static class UserBuilder
    {
        private Long id_user;
        private String nume;
        private String prenume;
        private String email;
        private String username;
        private String password;
        private String role;

        public UserBuilder()
        {

        }

        //pentru fiecare field se va crea o functie care primeste valoarea de salvat pentru acel field
        //si returneaza obiect builder obtinut dupa salvarea acestuia
        public UserBuilder id_user(Long id_user)
        {
            this.id_user = id_user;
            return this;
        }

        public UserBuilder nume(String nume)
        {
            this.nume = nume;
            return this;
        }

        public UserBuilder prenume(String prenume)
        {
            this.prenume = prenume;
            return this;
        }

        public UserBuilder email(String email)
        {
            this.email = email;
            return this;
        }

        public UserBuilder username(String username)
        {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password)
        {
            this.password = password;
            return this;
        }

        public UserBuilder role(String role)
        {
            this.role = role;
            return this;
        }

        public User build()
        {
            return new User(this);
        }
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Long getId() {
        return id_user;
    }

    public void setId(Long id_user) {
        this.id_user = id_user;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
