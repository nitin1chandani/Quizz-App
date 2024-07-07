package com.nitin.quizzapp.service;

import com.nitin.quizzapp.model.DTO.QuestionDetailsRequestDTO;
import com.nitin.quizzapp.model.DTO.QuestionDetailsResponseDTO;
import com.nitin.quizzapp.model.Question;
import com.nitin.quizzapp.repo.QuestionRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
    @Mock
    private QuestionRepo questionRepo;
    @InjectMocks
    private QuestionService questionService;


    @Test
    public void shouldReturnAllQuestions(){
        Question question = Question.builder()
                .category("coding")
                .difficultyLevel("medium")
                .questionTitle("What is an example of a bubble sort algorithm?")
                .rightAnswer("Comparing adjacent elements and swapping them if they are in the wrong order.")
                .option1("Iteratively searching for the largest element and placing it in its correct position.")
                .option2("Recursively dividing the array into halves until only one element remains.")
                .option3("Using a stack to reverse the order of elements in an array.")
                .option4("Sorting elements by comparing them with a pivot and recursively sorting the subarrays.")
                .build();

        when(questionRepo.findAll()).thenReturn(List.of(question));

        List<QuestionDetailsResponseDTO> result = questionService.getAllQuestions();
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getCategory(), "coding");
    }

    @Test
    public void shouldGetQuestionById(){
        Question question = Question.builder()
                .id(1l)
                .category("coding")
                .difficultyLevel("medium")
                .questionTitle("What is an example of a bubble sort algorithm?")
                .rightAnswer("Comparing adjacent elements and swapping them if they are in the wrong order.")
                .option1("Iteratively searching for the largest element and placing it in its correct position.")
                .option2("Recursively dividing the array into halves until only one element remains.")
                .option3("Using a stack to reverse the order of elements in an array.")
                .option4("Sorting elements by comparing them with a pivot and recursively sorting the subarrays.")
                .build();

        when(questionRepo.findById(1l)).thenReturn(Optional.ofNullable(question));
        QuestionDetailsResponseDTO result = questionService.getQuestionById(1l);
        assertEquals(result.getCategory(), "coding");
    }

    @Test
    public void shouldAddQuestionInDatabase(){

        Question question = Question.builder()
                .category("coding")
                .difficultyLevel("medium")
                .questionTitle("What is an example of a bubble sort algorithm?")
                .rightAnswer("Comparing adjacent elements and swapping them if they are in the wrong order.")
                .option1("Iteratively searching for the largest element and placing it in its correct position.")
                .option2("Recursively dividing the array into halves until only one element remains.")
                .option3("Using a stack to reverse the order of elements in an array.")
                .option4("Sorting elements by comparing them with a pivot and recursively sorting the subarrays.")
                .build();


        when(questionRepo.save(question)).thenReturn(question);
        QuestionDetailsRequestDTO questionDetailsRequestDTO = QuestionDetailsRequestDTO.builder()
                .category("coding")
                .difficultyLevel("medium")
                .questionTitle("What is an example of a bubble sort algorithm?")
                .rightAnswer("Comparing adjacent elements and swapping them if they are in the wrong order.")
                .option1("Iteratively searching for the largest element and placing it in its correct position.")
                .option2("Recursively dividing the array into halves until only one element remains.")
                .option3("Using a stack to reverse the order of elements in an array.")
                .option4("Sorting elements by comparing them with a pivot and recursively sorting the subarrays.")
                .build();
        Question savedQuestion = questionService.addQuestion(questionDetailsRequestDTO);
        assertEquals(question.getCategory(), savedQuestion.getCategory());
    }



}
