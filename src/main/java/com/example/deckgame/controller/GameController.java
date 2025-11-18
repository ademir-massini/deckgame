package com.example.deckgame.controller;

import com.example.deckgame.request.PlayRequest;
import com.example.deckgame.request.PlayResult;
import com.example.deckgame.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/play")
public class GameController {

    private final GameService gameService;
    public GameController(GameService gameService) { this.gameService = gameService; }

    @PostMapping
    public ResponseEntity<PlayResult> play(@RequestBody PlayRequest req) {
        PlayResult res = gameService.play(req);
        return ResponseEntity.ok(res);
    }
}