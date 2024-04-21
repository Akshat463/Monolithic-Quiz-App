package com.example.quizapp.controller;

import com.example.quizapp.service.QuestionService;
import com.example.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("hello")
    public String Hello(){
        return "Hello from Spring";
    }

    @GetMapping("allquestions")
    public ResponseEntity<List<Questions>> showAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Questions id){
        return questionService.deleteQuestion(id);
    }

}
