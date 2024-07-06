package com.nitin.quizzapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "questions", schema = "question_schema")
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "difficulty_lvl", nullable = false)
    private String difficultyLevel;

    @Column(name = "question_ttl", nullable = false, length = 1500)
    private String questionTitle;

    @Column(name = "right_ans", nullable = false, length = 100)
    private String rightAnswer;

    @Column(name = "opt_1", length = 100)
    private String option1;

    @Column(name = "opt_2", length = 100)
    private String option2;

    @Column(name = "opt_3", length = 100)
    private String option3;

    @Column(name = "opt_4", length = 100)
    private String option4;
}
