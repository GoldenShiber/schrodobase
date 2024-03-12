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
}
