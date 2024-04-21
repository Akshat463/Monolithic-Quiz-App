package com.example.quizapp.service;

import com.example.quizapp.model.Questions;
import com.example.quizapp.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    public ResponseEntity<List<Questions>> getAllQuestions() {

        try{
            return new ResponseEntity<List<Questions>>(questionRepository.findAll(),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        try{
            questionRepository.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error Occurred" ,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Questions question) {
        try{
            questionRepository.delete(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error Occurred" ,HttpStatus.BAD_REQUEST);

    }
}
