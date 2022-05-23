package com.example.homepricebot.controller;

import com.example.homepricebot.entity.Houses;
import com.example.homepricebot.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HousesController {

    @Autowired HousesService housesService;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Houses saveHouse(@RequestBody Houses houses) {
        return this.housesService.saveHouse(houses);
    }

    @GetMapping("/{id}")
    public Houses getHouse(@PathVariable long id) throws ResponseStatusException {
        return this.housesService.getHouseById(id);
    }

    @GetMapping("")
    public List<Houses> getAllHouses() {
        return this.housesService.getAllHouses();
    }

    @PostMapping(path = "/bulk", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Houses> saveAllHouse(@RequestBody List<Houses> houses) {
        return this.housesService.saveAllHouses(houses);
    }
}
