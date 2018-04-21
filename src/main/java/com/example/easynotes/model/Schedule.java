package com.example.easynotes.model;

import javax.persistence.*;


@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name="fromWhichDay")
    private String fromWhichDay;

    @Column(name="toWhichDay")
    private String toWhichDay;

    @Column(name = "time")
    private Integer time;

    @Column(name = "sports")
    private String sports;

    @Column(name = "description")
    private String description;

    public Schedule() {
    }

    public Schedule(String fromWhichDay, String toWhichDay, Integer time, String sports, String description) {
        this.fromWhichDay = fromWhichDay;
        this.toWhichDay = toWhichDay;
        this.time = time;
        this.sports = sports;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromWhichDay() {
        return fromWhichDay;
    }

    public void setFromWhichDay(String fromWhichDay) {
        this.fromWhichDay = fromWhichDay;
    }

    public String getToWhichDay() {
        return toWhichDay;
    }

    public void setToWhichDay(String toWhichDay) {
        this.toWhichDay = toWhichDay;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        return id != null ? id.equals(schedule.id) : schedule.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", fromWhichDay=" + fromWhichDay +
                ", toWhichDay=" + toWhichDay +
                ", time=" + time +
                ", sports='" + sports + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
