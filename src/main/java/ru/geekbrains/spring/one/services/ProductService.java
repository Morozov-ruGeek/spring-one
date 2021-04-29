package ru.geekbrains.spring.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findOneById(Long id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void saveWithCategory(String title, int cost, Long id_category) {
        categoryService.findById(id_category).ifPresent(c -> productRepository.save(new Product(title, cost, c)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void incrementScore(Long id) {
        Optional<Product> product = findOneById(id);
        product.ifPresent(p -> p.incrementCost());
    }

    @Transactional
    public void decrementScore(Long id) {
        Optional<Product> product = findOneById(id);
        product.ifPresent(p -> p.decrementCost());
    }

    public List<Product> findProductsByPrice(Integer minPrice, Integer maxPrice) {
        if (minPrice == null) {
            minPrice = 0;
        }
        if (maxPrice == null) {
            return productRepository.findAllByPriceGreaterThan(minPrice);
        }
        return productRepository.findAllByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> findAllByTitle(String title) {
        return productRepository.findAllByTitleLike("%"+title+"%");
//        return productRepository.hqlFindAllByTitle(title);
    }

    public List<Product> findProductsByFilter(Integer minPrice, Integer maxPrice, String title) {
        if (minPrice == null) {
            minPrice = 0;
        }
        if (title == null) {
            title = "%";
        } else {
            title = "%" + title + "%";
        }
        if (maxPrice == null) {
            return productRepository.findAllByPriceGreaterThanEqualAndTitleLike(minPrice, title);
        }
        return productRepository.findAllByPriceBetweenAndTitleLike(minPrice, maxPrice, title);
    }
}
