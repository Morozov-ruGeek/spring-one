package ru.geekbrains.spring.one.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.one.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("Select c FROM Category c JOIN FETCH c.product WHERE c.id=:id")
    Category hqlFindById(Long id);
}
