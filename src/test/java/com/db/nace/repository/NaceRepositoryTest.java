package com.db.nace.repository;

import com.db.nace.entity.Nace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class NaceRepositoryTest {

    @Autowired
    private NaceRepository naceRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testPersistNace(){

        testEntityManager.persist(getNaceEntity());
        Nace nace = naceRepository.findByOrderNum(111);
        Assertions.assertEquals(111,nace.getOrderNum());

    }

    private Nace getNaceEntity(){
        Nace nace = new Nace();
        nace.setOrderNum(111L);
        nace.setLevel(1L);
        nace.setCode("test");
        nace.setParent("test");
        nace.setDescription("test");
        return nace;
    }
}
