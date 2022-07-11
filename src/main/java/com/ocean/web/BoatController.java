package com.ocean.web;

import com.ocean.model.boat.Boat;
import com.ocean.model.boat.BoatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoatController {
    private final BoatRepository repository;

    @GetMapping("/boats")
    public int all() {
        return repository.findAll();
    }

    @GetMapping("/ping")
    public String  test() {
        return "pong";
    }

}
