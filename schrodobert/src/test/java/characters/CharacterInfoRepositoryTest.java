package characters;

import com.schrodobase.schrodobert.characters.CharacterInfo;
import com.schrodobase.schrodobert.characters.CharacterInfoRecord;
import com.schrodobase.schrodobert.characters.CharacterInfoRepository;
import com.schrodobase.schrodobert.controller.CharacterController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/*
    Test couple of methods with MVC:
    https://github.com/dakbhavesh/spring-boot-liquibase (older )
    https://github.com/h3yzack/springboot3-liquibase-example (updated from same author)
    https://github.com/h3yzack/springboot3-liquibase-example (new one )
    https://github.com/deepakbhalla/liquibase-springboot-h2-example ( 2 years old one )

    Testing documents: https://docs.spring.io/spring-framework/reference/testing.html
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration()
public class CharacterInfoRepositoryTest {

    @Autowired
    private CharacterInfoRepository repository;

    // we can use a WebTestClient to test a controller
    WebTestClient client =
            WebTestClient.bindToController(new CharacterController()).build();

    @Before
    public void init(){
        for(long index = 1; index < 3; index++){
            CharacterInfo characterInfo = new CharacterInfo(index, "janne", "banan");
            repository.save(characterInfo);
        }
    }

    @Test
    public void findAmountOfCities(){
        List<CharacterInfo> characterInfoList = repository.findAll();
        assertThat(characterInfoList.size()).isEqualTo(20);
    }

}
