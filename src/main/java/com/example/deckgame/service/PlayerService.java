package com.example.deckgame.service;

import com.example.deckgame.entity.PlayerEntity;
import com.example.deckgame.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {


    private final PlayerRepository repository;


    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }


    public List<PlayerEntity> findAll() {
        return repository.findAll();
    }


    public PlayerEntity save(PlayerEntity player) {
        return repository.save(player);
    }
}
