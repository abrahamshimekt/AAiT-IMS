package com.codewithabe.AAiT.repository;

import com.codewithabe.AAiT.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {
}
