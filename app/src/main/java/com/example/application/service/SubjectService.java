package com.example.application.service;

import com.example.application.entity.Subject;
import com.example.application.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> findAllByUserId(Long userId) {
        return subjectRepository.findAllByUserId(userId);
    }
}
