package com.example.easynotes.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="sleepTips")
public class SleepTips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sleepTips_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description" , length = 65535, columnDefinition="TEXT")
    @Type(type="text")
    private String description;

    @Column(name = "picture_url")
    private String picture_url;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sleepTips_tip", joinColumns = @JoinColumn(name = "tips_id"), inverseJoinColumns = @JoinColumn(name = "sleepTips_id"))
    private Set<Tip> tips = new HashSet<>();

    public SleepTips() {

    }

    public SleepTips(String title, String description, String picture_url) {
        this.title = title;
        this.description = description;
        this.picture_url = picture_url;
    }

    public SleepTips(String title, String description, String picture_url, Set<Tip> tips) {
        this.title = title;
        this.description = description;
        this.picture_url = picture_url;
        this.tips = tips;
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

    public Set<Tip> getTips() {
        return tips;
    }

    public void setTips(Set<Tip> tips) {
        this.tips = tips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SleepTips sleepTips = (SleepTips) o;

        return id != null ? id.equals(sleepTips.id) : sleepTips.id == null;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SleepTips{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", tips=" + tips +
                '}';
    }
}
