package com.example.deckgame.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.List;


@Component
public class DeckOfCardsApiClient {


    private final RestTemplate rest = new RestTemplate();
    private static final String BASE = "https://deckofcardsapi.com/api/deck";


    public String newShuffledDeck() {
        Map resp = rest.postForObject(BASE + "/new/shuffle/?deck_count=1", null, Map.class);
        return (String) resp.get("deck_id");
    }


    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> drawCards(String deckId, int count) {
        Map resp = rest.getForObject(BASE + "/" + deckId + "/draw/?count=" + count, Map.class);
        return (List<Map<String,Object>>) resp.get("cards");
    }
}
