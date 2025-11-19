package br.com.deckgame.controller;

import br.com.deckgame.request.PlayRequest;
import br.com.deckgame.request.PlayResult;
import br.com.deckgame.service.GameService;
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