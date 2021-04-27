package ru.geekbrains.spring.one.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.model.Category;
import ru.geekbrains.spring.one.model.Product;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;
    private static SessionFactory factory;
    private Category category;

    @Autowired
    public ProductRepository(SessionFactory factory){
        this.factory = factory;
    }

    public List<Product> findAllFromData() {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            products = session
                    .createNamedQuery("withCategory", Product.class)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void addProduct(Product product) {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public Optional<Product> findOneByIdFroData(Long id){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session
                    .createNamedQuery("withCategory", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return Optional.ofNullable(product);
        }
    }

    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product products = session.get(Product.class, id);
            session.delete(products);
            session.getTransaction().commit();
        }
    }
}
