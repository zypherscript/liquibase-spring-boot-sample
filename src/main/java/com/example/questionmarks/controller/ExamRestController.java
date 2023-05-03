package com.example.questionmarks.controller;

import com.example.questionmarks.dto.ExamCreationDTO;
import com.example.questionmarks.dto.ExamUpdateDTO;
import com.example.questionmarks.entity.Exam;
import com.example.questionmarks.repository.ExamRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamRestController {

  private final ExamRepository examRepository;
  private final ModelMapper modelMapper;

  @GetMapping
  public List<Exam> getExams() {
    return examRepository.findAll();
  }

  @PostMapping
  public void newExam(@RequestBody ExamCreationDTO examCreationDTO) {
    var exam = modelMapper.map(examCreationDTO, Exam.class);
    examRepository.save(exam);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void editExam(
      @RequestBody ExamUpdateDTO examUpdateDTO) { //need to use AOP/modelMapper to handle to be like @DTO
    var existingExam = examRepository.findById(examUpdateDTO.getId())
        .orElseThrow(NoSuchElementException::new);
    var exam = modelMapper.map(examUpdateDTO, Exam.class);
    exam.setCreatedAt(existingExam.getCreatedAt());
    examRepository.save(exam);
  }
}
