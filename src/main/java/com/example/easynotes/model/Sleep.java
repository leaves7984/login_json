package com.example.easynotes.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "sleep")
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sleep_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @Column(name = "article" , length = 65535, columnDefinition="MEDIUMTEXT")
    @Type(type="text")
    private String article;

    @Column(name = "picture_url")
    private String picture_url;

    @Column(name = "video_url")
    private String video_url;

    public Sleep() {
    }

    public Sleep(String title, String description, String article, String picture_url, String video_url) {
        this.title = title;
        this.description = description;
        this.article = article;
        this.picture_url = picture_url;
        this.video_url = video_url;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sleep sleep = (Sleep) o;

        return id != null ? id.equals(sleep.id) : sleep.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Sleep{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", article='" + article + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", video_url='" + video_url + '\'' +
                '}';
    }
}
