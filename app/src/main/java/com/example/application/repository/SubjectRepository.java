package com.example.application.repository;

import com.example.application.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllByUserId(Long userId);
}
