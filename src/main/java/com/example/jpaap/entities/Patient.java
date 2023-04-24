package com.example.jpaap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data//geters and seters
@Entity//creer une etity jpa (1)
@NoArgsConstructor
@AllArgsConstructor
public class Patient  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//(1)
    private Long id;
  @Column(length = 20)
    private String nom;
  @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
