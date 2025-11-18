package com.example.deckgame.request;

public class PlayRequest {
    private int players;
    private int cardsPerPlayer;


    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getCardsPerPlayer() {
        return cardsPerPlayer;
    }

    public void setCardsPerPlayer(int cardsPerPlayer) {
        this.cardsPerPlayer = cardsPerPlayer;
    }
}

