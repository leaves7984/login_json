package com.example.easynotes.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "tips")
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tips_id")
    private Long tips_id;

    @Column(name = "topic")
    private String topic;


    @Column(name = "content", length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String content;

    public Tip() {
    }

    public Tip(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    public Long getTips_id() {
        return tips_id;
    }

    public void setTips_id(Long tips_id) {
        this.tips_id = tips_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tip tip = (Tip) o;

        return tips_id != null ? tips_id.equals(tip.tips_id) : tip.tips_id == null;
    }

    @Override
    public int hashCode() {
        return tips_id != null ? tips_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "tips_id=" + tips_id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
