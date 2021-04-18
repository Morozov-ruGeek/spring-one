package ru.geekbrains.spring.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private Long id;
    private String name;
    private int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void changeScore(int incrementOrDecrementNumber){
        if (incrementOrDecrementNumber == +1 && this.score+1 <= 100){
            this.score++;
        }else if(incrementOrDecrementNumber == -1 && this.score-1 >= 0){
            this.score--;
        }
    }
}
