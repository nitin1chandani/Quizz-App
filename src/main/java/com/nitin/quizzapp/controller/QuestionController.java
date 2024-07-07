package com.nitin.quizzapp.controller;

import com.nitin.quizzapp.model.DTO.AssignmentRequestDTO;
import com.nitin.quizzapp.model.DTO.QuestionDetailsRequestDTO;
import com.nitin.quizzapp.model.DTO.QuestionDetailsResponseDTO;
import com.nitin.quizzapp.model.Question;
import com.nitin.quizzapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<QuestionDetailsResponseDTO>> getAllQuestions(){
        List<QuestionDetailsResponseDTO> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionDetailsResponseDTO> getQuestionById(@PathVariable Long id){
        QuestionDetailsResponseDTO questionDetailsResponseDTO = questionService.getQuestionById(id);
        if(questionDetailsResponseDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionDetailsResponseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDetailsRequestDTO questionDetailsRequestDTO){
        Question question = questionService.addQuestion(questionDetailsRequestDTO);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping(value = "/assignment")
    public ResponseEntity<List<QuestionDetailsResponseDTO>> getAssignmentForParticularLanguage(@RequestBody AssignmentRequestDTO assignmentRequestDTO){
        List<QuestionDetailsResponseDTO> questions = questionService.getQuestionsForAssignment(assignmentRequestDTO);
        if(questions.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
