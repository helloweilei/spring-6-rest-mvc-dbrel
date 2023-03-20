package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Transactional
    public void testCreateCategory() {
        Beer beer = beerRepository.findAll().get(0);
        Category category = Category.builder()
                .description("Hot")
                .build();
        category.getBeers().add(beer);

        Category savedCat = categoryRepository.saveAndFlush(category);
        System.out.println(savedCat);
    }
}
