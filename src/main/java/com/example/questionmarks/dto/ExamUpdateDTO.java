package com.example.questionmarks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamUpdateDTO {

  @Id
  @NotNull
  private Long id;

  @NotNull
  private String title;

  @NotNull
  private String description;

  @JsonIgnore
  private final LocalDateTime editedAt = LocalDateTime.now();
}
