package com.example.homepricebot.repo;

import com.example.homepricebot.entity.Houses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesRepository extends CrudRepository<Houses, Long> {
}

