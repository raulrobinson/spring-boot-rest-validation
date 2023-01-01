package com.rasysbox.entity;

import com.rasysbox.error.validator.Author;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Please provide a name")
    private String name;

    @Author
    @NotEmpty(message = "Please provide a author")
    private String author;

    @NotNull(message = "Please provide a score")
    @DecimalMin("1.00")
    private BigDecimal score;

    /**
     * Warning!!!
     * Avoid this "No default constructor for entity"
     */
    public Movie() {
    }

    public Movie(Long id, String name, String author, BigDecimal score) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.score = score;
    }

    public Movie(String name, String author, BigDecimal score) {
        this.name = name;
        this.author = author;
        this.score = score;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", score=" + score +
                '}';
    }
}
