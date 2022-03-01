package com.project.bookstore;

import com.project.bookstore.model.Produs;
import com.project.bookstore.model.User;
import com.project.bookstore.repository.AdminRepository;
import com.project.bookstore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreate() {
        User user = new User();
        user.setNume("Popescu");
        user.setPrenume("Mihai");
        user.setEmail("mihai.popescu@gmail.com");
        user.setUsername("mihaip");
        user.setPassword("mihai2021");
        user.setRole("client");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());

    }

    @Test
    public void findUserByUsername()
    {
        String username = "george2000";
        User user = repo.findByUsername(username);

        assertThat(user).isNotNull();
    }
}
