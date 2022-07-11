package com.ocean;

import com.ocean.model.boat.Boat;
import com.ocean.model.boat.BoatRepository;
import com.ocean.model.guest.GuestRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class BoatRepoTest {

    @Autowired
    BoatRepository boatRepository;
    @Autowired
    GuestRepository guestRepository;

    @Test
    public void when2collectionThenExecuteAndMerge2queryJPQL(){
        Boat boat = boatRepository.getByName2Query("LODKA1");

        assertEquals(2, boat.getLifeRafts().size());
        assertEquals(2, boat.getSeamen().size());
        //log.error("Boat " + boat);
        //log.error("LR " +boat.getLifeRafts());
        //log.error("SM " +boat.getSeamen());
    }

    @Test
    @Transactional
    public void show_doule_delete(){
        Boat boat = boatRepository.getByName2Query("LODKA1");

        //one delete operator
        boat.getLifeRafts().clear();
        log.error("====================================");
        log.error("====================================");
        //two delete operator
        boat.getSeamen().clear();
        boatRepository.getByName(boat);
        log.error("Size " + boat.getLifeRafts().size());
        boatRepository.getByName(boat);
    }

    @Test
    public void test(){
        Random rand = new Random();
        int i = rand.nextInt(3);
        System.out.println("#############################");
        System.out.println(i);
//        System.out.println("olo");
        System.out.println(new Random());
        new Dog();
    }

    class Dog{};


}
