package com.nitin.quizzapp.repo;

import com.nitin.quizzapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    List<Question> findQuestionByCategoryAndDifficultyLevel(String category, String difficultyLevel);

}
