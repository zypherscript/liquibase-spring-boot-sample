package com.example.questionmarks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Attempt {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "alternative_id")
  private Alternative alternative;

  @NotNull
  private Date date;

  private boolean correct;
}
