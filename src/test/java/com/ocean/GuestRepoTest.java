package com.ocean;

import com.ocean.model.boat.Boat;
import com.ocean.model.boat.BoatRepository;
import com.ocean.model.boat.TypeBoat;
import com.ocean.model.guest.Guest;
import com.ocean.model.guest.GuestRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class GuestRepoTest {

    @Autowired
    BoatRepository boatRepository;
    @Autowired
    GuestRepository guestRepository;

    @Test
    public void show_N1_problem_when_ManyToOne(){
        log.warn("====================================");
        log.warn("====================================");
        List<Guest> guests = guestRepository.getGuestsWithN1();
        log.warn("====================================");
    }

    @Test
    public void show_fixed_N1_problem_when_use_join(){
        log.warn("====================================");
        log.warn("====================================");
        List<Guest> guests = guestRepository.getGuestsWithJoin();
        log.warn("====================================");
    }

}
