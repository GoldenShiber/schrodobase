package com.schrodobase.schrodobert.characters;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// TODO This looks really nice to have!
public interface CharacterInfoRepository extends JpaRepository<CharacterInfo, Long> {
    List<CharacterInfoRecord> findCharacterInfoByPlayerName(String playerName);
}
