package com.schrodobase.schrodobert.characters;

import com.schrodobase.schrodobert.characters.CharacterInfo;
import com.schrodobase.schrodobert.characters.CharacterInfoRecord;
import com.schrodobase.schrodobert.characters.CharacterInfoRepository;
import com.schrodobase.schrodobert.controller.CharacterController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
    Test couple of methods with MVC:
    https://github.com/dakbhavesh/spring-boot-liquibase (older )
    https://github.com/h3yzack/springboot3-liquibase-example (updated from same author)
    https://github.com/h3yzack/springboot3-liquibase-example (new one )
    https://github.com/deepakbhalla/liquibase-springboot-h2-example ( 2 years old one )

    Testing documents: https://docs.spring.io/spring-framework/reference/testing.html

    Could possible look at datajpatest instead
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@DataJpaTest
public class CharacterInfoRepositoryTest {

    @Autowired
    private CharacterInfoRepository repository;

    // Test the lifecycle property

    private CharacterInfo characterInfo;
    @Before
    public void setUp(){
        CharacterInfo characterInfo = new CharacterInfo(1L, "janne", "banan");
        repository.save(characterInfo);
    }

    @AfterEach
    public void tearDown() {
        // Release test data after each test method
        repository.delete(characterInfo);
    }

    @Test
    public void givenCharacter_whenSaved_thenCanBeFoundById(){
        CharacterInfo saveCharacterInfo = repository.findById(characterInfo.getId()).orElse(null);
        assertNotNull(characterInfo);
        assertEquals(characterInfo.getName(), saveCharacterInfo.getName());
        assertEquals(characterInfo.getPlayerName(), saveCharacterInfo.getPlayerName());
    }

}
