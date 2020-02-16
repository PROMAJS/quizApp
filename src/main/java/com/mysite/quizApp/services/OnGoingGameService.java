package com.mysite.quizApp.services;

import com.mysite.quizApp.dto.QuestionsDto;
import com.mysite.quizApp.frontend.Difficulty;
import com.mysite.quizApp.frontend.GameOptions;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log
public class OnGoingGameService {

    private GameOptions gameOptions;
    private int currentQuestionIndex;
    @Getter
    private int points;

    private List<QuestionsDto.QuestionDto> questions;

    @Autowired
    private QuizDataService quizDataService;

    public void init(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        this.currentQuestionIndex = 0;
        this.points = 0;

        this.questions = quizDataService.getQuizQuestions(gameOptions);
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex + 1;
    }

    public int getTotalQuestionNumber() {
        return questions.size();
    }

    public String getCurrentQuestion() {
        QuestionsDto.QuestionDto questionsDto = questions.get(currentQuestionIndex);
        return questionsDto.getQuestion();
    }

    public List<String> getCurrentQuestionAnswersInRandomOrder() {
        QuestionsDto.QuestionDto questionDto = questions.get(currentQuestionIndex);

        List<String> answers = new ArrayList<>();
        answers.add(questionDto.getCorrectAnswer());
        answers.addAll(questionDto.getIncorrectAnswer());

        Collections.shuffle(answers);

        return answers;
    }

   public boolean checkAnswerForCurrentQuestion(String userAnswer) {
       QuestionsDto.QuestionDto questionDto = questions.get(currentQuestionIndex);
       boolean correct = questionDto.getCorrectAnswer().equals(userAnswer);
       if(correct){
           points++;
       }
       return correct;
   }

    public boolean proceedToNextQuestion() {
        currentQuestionIndex++;
        return currentQuestionIndex < questions.size();
    }

    public Difficulty getDifficulty(){
        return gameOptions.getDifficulty();
    }

    public String getCategoryName(){
        Optional<String> category = quizDataService.getQuizCategories().stream()
                .filter(categoryDto -> categoryDto.getId() == gameOptions.getCategoryId())
                .map(categoryDto -> categoryDto.getName())
                .findAny();
        return category.orElse(null);
    }
}
