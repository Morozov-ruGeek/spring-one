package ru.geekbrains.spring.one.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.one.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByTitleLike(String title);
    List<Product> findAllByPriceGreaterThan(int min);
    List<Product> findAllByPriceBetween(int min, int max);
    List<Product> findAllByPriceGreaterThanEqualAndTitleLike(int min, String title);
    List<Product> findAllByPriceBetweenAndTitleLike(int min, int max, String title);
}
