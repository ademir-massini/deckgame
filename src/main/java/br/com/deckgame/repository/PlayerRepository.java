package br.com.deckgame.repository;

import br.com.deckgame.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
