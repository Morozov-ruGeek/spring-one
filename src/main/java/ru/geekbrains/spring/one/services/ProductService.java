package ru.geekbrains.spring.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAllFromData();
    }

    public Optional<Product> findOneByIdFroData(Long id) {
        return productRepository.findOneByIdFroData(id);
    }

    public void save(Product product) {
        productRepository.addProduct(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeScoreById(Long id, int changeNumber){
        productRepository.findOneByIdFroData(id).get().changeScore(changeNumber);
    }

}
