package org.javastart.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String url;
    @ManyToOne
    private Category category;

    public Recipe() {
    }

    public Recipe(String title, String description, String url, Category category) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return title + '\n' +
                description;
    }
}
