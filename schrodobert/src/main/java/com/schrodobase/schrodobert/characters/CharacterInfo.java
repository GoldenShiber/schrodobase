package com.schrodobase.schrodobert.characters;

import jakarta.persistence.*;

@Entity
@Table(name="characterInfo")
public class CharacterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String playerName;

    public CharacterInfo(Long id, String name, String playerName) {
        this.id = id;
        this.name = name;
        this.playerName = playerName;
    }

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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
