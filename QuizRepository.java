package com.example.quizapp.dao;

import com.example.quizapp.model.Questions;
import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}
