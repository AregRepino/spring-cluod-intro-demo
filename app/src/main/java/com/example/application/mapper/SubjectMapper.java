package com.example.application.mapper;

import com.example.application.dto.SubjectDto;
import com.example.application.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SubjectMapper {
    public SubjectDto toSubjectDto(Subject subject) {
        if(subject == null) {
            return null;
        }
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setUserId(subject.getUser().getId());
        subjectDto.setName(subject.getName());
        return subjectDto;
    }

    public List<SubjectDto> toSubjectDtos(List<Subject> subjects) {
        if(subjects == null) {
            return new ArrayList<>();
        }
        return subjects.stream().map(this::toSubjectDto).collect(Collectors.toList());
    }
}
