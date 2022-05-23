package com.example.homepricebot.service;

import com.example.homepricebot.entity.Houses;
import com.example.homepricebot.repo.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class HousesService {

    @Autowired HousesRepository housesRepository;

    public List<Houses> getAllHouses() {
        List<Houses> housesList = new ArrayList<>();
        housesRepository.findAll().forEach(housesList::add);
        return housesList;
    }

    public List<Houses> saveAllHouses(List<Houses> housesList) {
        return (List<Houses>) housesRepository.saveAll(housesList);
    }

    public Houses getHouseById(Long id) {
        return housesRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "House not found"
                )
        );
    }

    public Houses saveHouse(Houses houses) {
        return housesRepository.save(houses);
    }
}
