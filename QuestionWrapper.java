package com.example.quizapp.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String problem;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Integer id, String problem, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.problem = problem;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
