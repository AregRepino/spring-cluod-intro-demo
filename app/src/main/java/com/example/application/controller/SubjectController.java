package com.example.application.controller;

import com.example.application.dto.SubjectDto;
import com.example.application.entity.Subject;
import com.example.application.mapper.SubjectMapper;
import com.example.application.service.SubjectService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;


    @GetMapping
    public List<SubjectDto> findAllSubjects(@RequestParam("userId") Long userId) {
        List<Subject> subjects = this.subjectService.findAllByUserId(userId);
        return this.subjectMapper.toSubjectDtos(subjects);
    }

    //    Пример, как можно было бы вытащить данные из HTTP сессии.
    @GetMapping("/v2")
    public List<SubjectDto> findAllSubjectsBySessionParam(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return this.findAllSubjects(userId);
    }
}
