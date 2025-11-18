package com.example.deckgame.entity;


import javax.persistence.*;

@Entity
@Table(name = "cards")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;   // A, K, Q, J, 10, 2...
    private String suit;    // HEARTS, SPADES, etc
    private Integer numericValue;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    public CardEntity() {}

    public CardEntity(String value, String suit, Integer numericValue, PlayerEntity player) {
        this.value = value;
        this.suit = suit;
        this.numericValue = numericValue;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Integer numericValue) {
        this.numericValue = numericValue;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }
}