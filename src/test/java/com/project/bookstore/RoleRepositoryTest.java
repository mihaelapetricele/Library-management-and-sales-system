package com.project.bookstore;

import com.project.bookstore.model.Role;
import com.project.bookstore.model.User;
import com.project.bookstore.repository.RoleRepository;
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
public class RoleRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateRole() {
        Role role = new Role();
        role.setName("CLIENT");

        Role savedRole = repo.save(role);

        Role existRole = entityManager.find(Role.class, savedRole.getId_role());

        assertThat(role.getName()).isEqualTo(existRole.getName());

    }
}
