package com.nitin.quizzapp.service;

import com.nitin.quizzapp.model.DTO.QuestionDetailsRequestDTO;
import com.nitin.quizzapp.model.DTO.QuestionDetailsResponseDTO;
import com.nitin.quizzapp.model.Question;
import com.nitin.quizzapp.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepo questionRepo;

    public List<QuestionDetailsResponseDTO> getAllQuestions(){
        try{
            List<Question> questions = questionRepo.findAll();
            List<QuestionDetailsResponseDTO> listOfQuestions = createListOfQuestions(questions);
            return listOfQuestions;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch questions", e);
        }
    }

    public QuestionDetailsResponseDTO getQuestionById(Long id){
        try{
            Optional<Question> question = questionRepo.findById(id);
            if(question.isPresent()){
                return createQuestionDetailResponseDTOObject(question.get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Question addQuestion(QuestionDetailsRequestDTO questionDetailsRequestDTO){
        try{
            Question question = createQuestionObject(questionDetailsRequestDTO);
            Question question1 = questionRepo.save(question);
            return question1;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to Save Question");
        }
    }

    private QuestionDetailsResponseDTO createQuestionDetailResponseDTOObject(Question question){
        return QuestionDetailsResponseDTO.builder()
                .id(question.getId())
                .category(question.getCategory())
                .difficultyLevel(question.getDifficultyLevel())
                .questionTitle(question.getQuestionTitle())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .option4(question.getOption4())
                .build();
    }

    private Question createQuestionObject(QuestionDetailsRequestDTO questionDetailsRequestDTO){
        Question question = Question.builder()
                .questionTitle(questionDetailsRequestDTO.getQuestionTitle())
                .category(questionDetailsRequestDTO.getCategory())
                .difficultyLevel(questionDetailsRequestDTO.getDifficultyLevel())
                .option1(questionDetailsRequestDTO.getOption1())
                .option2(questionDetailsRequestDTO.getOption2())
                .option3(questionDetailsRequestDTO.getOption3())
                .option4(questionDetailsRequestDTO.getOption4())
                .rightAnswer(questionDetailsRequestDTO.getRightAnswer())
                .build();
        return question;
    }

    private List<QuestionDetailsResponseDTO> createListOfQuestions(List<Question> questions){
        List<QuestionDetailsResponseDTO> listOfQuestions = questions.stream()
                .map(question -> QuestionDetailsResponseDTO.builder()
                        .id(question.getId())
                        .category(question.getCategory())
                        .difficultyLevel(question.getDifficultyLevel())
                        .questionTitle(question.getQuestionTitle())
                        .option1(question.getOption1())
                        .option2(question.getOption2())
                        .option3(question.getOption3())
                        .option4(question.getOption4())
                        .build())
                .collect(Collectors.toList());
        return listOfQuestions;
    }

}
