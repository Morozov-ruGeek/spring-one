package ru.geekbrains.spring.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products_info")
@NamedQueries({
        @NamedQuery(name = "withCategory", query = "SELECT p FROM Product p JOIN FETCH p.category WHERE p.id = :id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinTable(name = "category_id")
    private Category category;

    public void changeScore(int incrementOrDecrementNumber){
        if (incrementOrDecrementNumber == +1 && this.price+1 <= 100){
            this.price++;
        }else if(incrementOrDecrementNumber == -1 && this.price-1 >= 0){
            this.price--;
        }
    }
}
