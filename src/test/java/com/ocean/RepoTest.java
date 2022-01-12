package com.ocean;

import com.ocean.model.Sailboat;
import com.ocean.model.SailboatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepoTest {

    @Autowired
    SailboatRepository repository;

    @Test
    public void findUserById() {
        repository.save(new Sailboat("olo"));
        //Sailboat findSB = repository.find(1L);
        Sailboat findSB = repository.find();
        System.out.println();
        System.out.println(findSB.toString());
        System.out.println();

        //Sailboat findSB2 = repository.find(1L);
        Sailboat findSB2 = repository.find();
        System.out.println();
        System.out.println(findSB2.toString());
        System.out.println();
        System.out.println("SB1Name=" + findSB.getName());

//        repository.saveAll(Lists.newArrayList(
//                new User("1", "John", "Doe", "JDoe123", new Profile(...,new ProfileEntity(1, "token123"))),
//        new User("2", "Jane", "Doe", "TheJane", new Profile(...,new ProfileEntity(2, "token234")))));
//        UserBillingDTO dto = repository.findUserForBilling("1");
//        assertThat(dto.getId()).isEqualTo("1");
    }
}
