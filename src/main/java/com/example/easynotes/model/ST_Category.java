package com.example.easynotes.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="sleepTipsCategory")
public class ST_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description" , length = 65535, columnDefinition="TEXT")
    @Type(type="text")
    private String description;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_tips", joinColumns = @JoinColumn(name = "sleepTips_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<SleepTips> sleepTips = new HashSet<>();

    public ST_Category() {
    }

    public ST_Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ST_Category(String title, String description, Set<SleepTips> sleepTips) {
        this.title = title;
        this.description = description;
        this.sleepTips = sleepTips;
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

    public Set<SleepTips> getSleepTips() {
        return sleepTips;
    }

    public void setSleepTips(Set<SleepTips> sleepTips) {
        this.sleepTips = sleepTips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ST_Category that = (ST_Category) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SleepTipsCategory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sleepTips=" + sleepTips +
                '}';
    }
}
