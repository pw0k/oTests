package com.ocean;

import com.ocean.model.boat.Boat;
import com.ocean.model.boat.BoatRepository;
import com.ocean.model.boat.LifeRaft;
import com.ocean.model.boat.TypeBoat;
import com.ocean.model.guest.Guest;
import com.ocean.model.guest.GuestRepository;
import com.ocean.model.seaman.Seaman;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {
    private final BoatRepository boatRepository;
    private final GuestRepository guestRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Boat boat = new Boat();
        boat.setName("LODKA1");
        boat.setType(TypeBoat.SAILBOAT);
        boat.getLifeRafts().add(new LifeRaft("LF1"));
        boat.getLifeRafts().add(new LifeRaft("LF2"));
        boat.getSeamen().add(new Seaman("Seaman1"));
        boat.getSeamen().add(new Seaman("Seaman2"));


        Boat boat2 = new Boat();
        boat2.setName("LODKA2");
        Boat boat3 = new Boat();
        boat3.setName("LODKA3");

        boatRepository.save(boat);
        boatRepository.save(boat2);
        boatRepository.save(boat3);

    }
}
