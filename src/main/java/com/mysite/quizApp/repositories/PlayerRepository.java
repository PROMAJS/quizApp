package com.mysite.quizApp.repositories;

import com.mysite.quizApp.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {




}
