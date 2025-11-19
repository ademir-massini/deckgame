package br.com.deckgame.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Um player possui várias cartas na mão
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CardEntity> cards = new ArrayList<>();

    @Column(nullable = false)
    private Integer totalScore;

    public PlayerEntity() {
    }

    public PlayerEntity(String name) {
        this.name = name;
        this.totalScore = 0;
    }

    // getters e setters (sem Lombok)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CardEntity> getCards() {
        return cards;
    }

    public void setCards(List<CardEntity> cards) {
        this.cards = cards;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}