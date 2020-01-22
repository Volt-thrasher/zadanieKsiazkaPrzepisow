package org.javastart.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private CategoryName categoryName;

    public Category() {
    }

    public Category(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryName getName() {
        return categoryName;
    }

    public void setName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

}
