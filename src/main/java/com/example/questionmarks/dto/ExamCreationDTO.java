package com.example.questionmarks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamCreationDTO {

  @NotNull
  private String title;

  @NotNull
  private String description;

  @JsonIgnore
  private final LocalDateTime createdAt = LocalDateTime.now();

  @JsonIgnore
  private final LocalDateTime editedAt = LocalDateTime.now();
}
