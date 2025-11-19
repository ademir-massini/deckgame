package br.com.deckgame.controller;

import br.com.deckgame.entity.PlayerEntity;
import br.com.deckgame.service.PlayerService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlayerEntity> getAll() {
        return service.findAll();
    }


    @PostMapping
    public PlayerEntity create(@RequestBody PlayerEntity player) {
        return service.save(player);
    }
}