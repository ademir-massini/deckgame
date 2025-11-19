package br.com.deckgame.service;

import br.com.deckgame.request.PlayRequest;
import br.com.deckgame.request.PlayResult;
import br.com.deckgame.utils.CardUtils;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class GameService {


    private final DeckOfCardsApiClient deckClient;


    public GameService(DeckOfCardsApiClient deckClient) {
        this.deckClient = deckClient;
    }

    public PlayResult play(PlayRequest req) {
        if (req.getPlayers() <= 0 || req.getCardsPerPlayer() <= 0) {
            throw new IllegalArgumentException("O número de jogadores e cartas por mão deve ser > 0.");
        }

        int totalCards = req.getPlayers() * req.getCardsPerPlayer();
        String deckId = deckClient.newShuffledDeck();
        List<Map<String,Object>> drawn = deckClient.drawCards(deckId, totalCards);

        List<List<Map<String,Object>>> hands = new ArrayList<>();
        for (int p = 0; p < req.getPlayers(); p++) {
            int start = p * req.getCardsPerPlayer();
            int end = start + req.getCardsPerPlayer();
            hands.add(drawn.subList(start, end));
        }

        List<PlayerScore> scores = new ArrayList<>();
        for (int i = 0; i < hands.size(); i++) {
            List<Map<String,Object>> hand = hands.get(i);
            int sum = 0;
            List<String> cards = new ArrayList<>();
            for (Map<String,Object> c : hand) {
                String value = (String) c.get("value");
                cards.add(value);
                sum += CardUtils.valueToInt(value);
            }
            scores.add(new PlayerScore("Player " + (i+1), sum, cards));
        }

        // Lista completa dos jogadores (players)
        List<PlayResult.PlayerResult> allPlayers = scores.stream()
                .map(s -> {
                    PlayResult.PlayerResult pr = new PlayResult.PlayerResult();
                    pr.setName(s.name);
                    pr.setSum(s.sum);
                    pr.setCards(s.cards);
                    return pr;
                })
                .collect(Collectors.toList());


        // Encontrar o(s) vencedor(es)
        int max = scores.stream().mapToInt(s -> s.sum).max().orElse(0);

        List<PlayResult.PlayerResult> winners = scores.stream()
                .filter(s -> s.sum == max)
                .map(s -> {
                    PlayResult.PlayerResult pr = new PlayResult.PlayerResult();
                    pr.setName(s.name);
                    pr.setSum(s.sum);
                    pr.setCards(s.cards);
                    return pr;
                }).collect(Collectors.toList());


        // Montar resposta completa
        PlayResult result = new PlayResult();
        result.setPlayers(allPlayers);
        result.setWinners(winners);

        return result;
    }


    private static class PlayerScore {
        String name;
        int sum;
        List<String> cards;
        PlayerScore(String name, int sum, List<String> cards) { this.name = name; this.sum = sum; this.cards = cards; }
    }
}
