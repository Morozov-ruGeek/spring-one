package ru.geekbrains.spring.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "students_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private int score;

    public void changeScore(int incrementOrDecrementNumber){
        if (incrementOrDecrementNumber == +1 && this.score+1 <= 100){
            this.score++;
        }else if(incrementOrDecrementNumber == -1 && this.score-1 >= 0){
            this.score--;
        }
    }
}
