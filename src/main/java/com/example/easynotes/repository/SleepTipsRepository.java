package com.example.easynotes.repository;

import com.example.easynotes.model.SleepTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface SleepTipsRepository extends JpaRepository<SleepTips,Long> {
    public SleepTips findByTitle(String title);
}
