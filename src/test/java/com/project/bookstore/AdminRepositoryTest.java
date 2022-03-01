package com.project.bookstore;

import com.project.bookstore.model.Produs;
import com.project.bookstore.repository.AdminRepository;
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
public class AdminRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdminRepository repos;

    @Test
    public void testCreateProd() {
        Produs produs = new Produs();
        produs.setAutor("Colleen Hoover");
        produs.setCantitate(100);
        produs.setEditura("Bookzone");
        produs.setGen("romance");
        produs.setImagine("pictures/books/book1.png");
        produs.setPret(35.5);
        produs.setTitlu("It ends with us");

        Produs savedProdus = repos.save(produs);

        Produs existProdus = entityManager.find(Produs.class, savedProdus.getId_prod());

        assertThat(produs.getTitlu()).isEqualTo(existProdus.getTitlu());

    }
}
