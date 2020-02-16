package com.mysite.quizApp.quiz;

import com.mysite.quizApp.entities.PlayerEntity;
import com.mysite.quizApp.repositories.PlayerRepository;
import com.mysite.quizApp.services.QuizDataService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Log
public class StartUpRunner implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    @Override
    @Transactional
    public void run(String...args) throws Exception {
        log.info("Executing startup actions...");
        playerRepository.save(new PlayerEntity("Olo"));
        playerRepository.save(new PlayerEntity("Ziomo"));
        playerRepository.save(new PlayerEntity("Chrystek"));

        log.info("Players list :");
        List<PlayerEntity> playersFromDataBase = playerRepository.findAll();
        for(PlayerEntity playerFromDb : playersFromDataBase)
        {
            log.info("Retrieved " + playerFromDb);
        }

        quizDataService.getQuizCategories();

    }
}
