package com.example.easynotes.repository;

import com.example.easynotes.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
//@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080","file://*"})
@CrossOrigin
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
