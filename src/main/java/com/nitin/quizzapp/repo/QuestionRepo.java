package com.nitin.quizzapp.repo;

import com.nitin.quizzapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}
