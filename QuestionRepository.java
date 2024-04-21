package com.example.quizapp.dao;

import com.example.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface QuestionRepository extends JpaRepository<Questions, Integer> {

    public List<Questions> findByCategory(String category);


    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY Random() LIMIT :numQ",nativeQuery = true)
    public List<Questions> findRandomQuestionsByCategory(String category,int numQ);
}
