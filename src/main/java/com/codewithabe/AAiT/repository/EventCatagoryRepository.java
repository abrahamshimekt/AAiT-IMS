package com.codewithabe.AAiT.repository;

import com.codewithabe.AAiT.models.EventCatagory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCatagoryRepository extends CrudRepository<EventCatagory, Integer> {
}
