package com.example.questionmarks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Exam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String title;

  @NotNull
  private String description;

  @NotNull
  private LocalDateTime createdAt;

  @NotNull
  private LocalDateTime editedAt;

  @NotNull
  private boolean published;
}