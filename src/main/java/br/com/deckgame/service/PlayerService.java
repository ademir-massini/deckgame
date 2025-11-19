package br.com.deckgame.service;

import br.com.deckgame.entity.PlayerEntity;
import br.com.deckgame.repository.PlayerRepository;
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
