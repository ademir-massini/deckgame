package com.example.deckgame.request;

import java.util.List;


public class PlayResult {
    private List<PlayerResult> players;
    private List<PlayerResult> winners;

    public List<PlayerResult> getPlayers() { return players; }
    public void setPlayers(List<PlayerResult> players) { this.players = players; }

    public List<PlayerResult> getWinners() { return winners; }
    public void setWinners(List<PlayerResult> winners) { this.winners = winners; }

    public static class PlayerResult {
        private String name;
        private int sum;
        private List<String> cards;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getSum() { return sum; }
        public void setSum(int sum) { this.sum = sum; }

        public List<String> getCards() { return cards; }
        public void setCards(List<String> cards) { this.cards = cards; }
    }
}