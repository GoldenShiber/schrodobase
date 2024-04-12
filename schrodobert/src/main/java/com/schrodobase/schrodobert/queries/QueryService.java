package com.schrodobase.schrodobert.queries;

import com.schrodobase.schrodobert.characters.CharacterInfo;
import com.schrodobase.schrodobert.characters.CharacterInfoRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QueryService {
    @PersistenceContext
    private EntityManager entityManager;


    // Based on: https://www.baeldung.com/spring-jpa-java-records
    public List<CharacterInfoRecord> findAllCharactersInfo(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        // We create a CriteriaQuery using the CriteriaBuilder.createQuery() method.
        // We pass the class of the record that we want to return as the parameter
        CriteriaQuery<CharacterInfoRecord> query = cb.createQuery(CharacterInfoRecord.class);
        // We then create a Root using the CriteriaQuery.from() method. We pass the entity class as the parameter.
        // This is how we specify the table that we want to query
        Root<CharacterInfo> root = query.from(CharacterInfo.class);
        // Then, we use the CriteriaQuery.select() method to specify a select clause.
        // We use the CriteriaBuilder.construct() method to convert the query results to a record.
        // We pass the class of the record and the fields of the entity that we want to pass to the
        // record constructor as the parameters
        query.select(cb.construct(CharacterInfoRecord.class, root.get("id"), root.get("name"), root.get("playerName")));
        // Finally, we use the EntityManager.createQuery() method to create a TypedQuery from CriteriaQuery.
        // We then use the TypedQuery.getResultList() method to get the results of the query
        return entityManager.createQuery(query).getResultList();
    }

    // Typed Query with Records
    public CharacterInfoRecord findByName(String name){
        TypedQuery<CharacterInfoRecord> query = entityManager
                .createQuery("This is where we put the SQL clause", CharacterInfoRecord.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

}
