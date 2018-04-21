package com.example.easynotes.repository;

import com.example.easynotes.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface TipRepository extends JpaRepository<Tip,Long>{

}
