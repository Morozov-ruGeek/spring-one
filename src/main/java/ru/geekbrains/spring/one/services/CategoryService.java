package ru.geekbrains.spring.one.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.one.model.Category;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Product> findProductByCategory(Long id) {
        return categoryRepository.hqlFindById(id).getProduct();
    }
}
