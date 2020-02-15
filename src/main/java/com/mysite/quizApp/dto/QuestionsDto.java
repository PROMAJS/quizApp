package com.mysite.quizApp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
public class QuestionsDto {

    @JsonProperty("response_code")
    private int responseCode;
    @JsonProperty("results")
    private List<QuestionDto> questions;

    @NoArgsConstructor
    @Getter
    @ToString
    public static class QuestionDto {
        private String category;
        private String type;
        private String difficulty;
        private String question;
        @JsonProperty("correct_answer")
        private String correctAnswer;
        @JsonProperty("incorrect_answer")
        private List<String> incorrectAnswer;


    }

}
