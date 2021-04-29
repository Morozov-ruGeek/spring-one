package ru.geekbrains.spring.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "deleteById", query = "delete from Product p where p.id = :id")
})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products_info")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String title, int price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public void incrementCost() {
        if (price < Integer.MAX_VALUE) {
            price++;
        }
    }

    public void decrementCost() {
        if (price > 0) {
            price--;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title=" + title + '\'' +
                ", cost=" + price + "}";
    }
}
