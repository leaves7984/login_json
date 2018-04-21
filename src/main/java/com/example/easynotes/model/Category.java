package com.example.easynotes.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description" , length = 65535, columnDefinition="TEXT")
    @Type(type="text")
    private String description;

    @Column(name = "picture_url")
    private String picture_url;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_sleep", joinColumns = @JoinColumn(name = "sleep_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Sleep> articles = new HashSet<>();

    public Category() {

    }

    public Category(String title, String description, String picture_url) {
        this.title = title;
        this.description = description;
        this.picture_url = picture_url;
    }

    public Category(String title, String description, String picture_url, Set<Sleep> articles) {
        this.title = title;
        this.description = description;
        this.picture_url = picture_url;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Set<Sleep> getArticles() {
        return articles;
    }

    public void setArticles(Set<Sleep> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return id != null ? id.equals(category.id) : category.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", articles=" + articles +
                '}';
    }
}
