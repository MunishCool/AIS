package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Slot;

public interface ISlotRepo extends JpaRepository<Slot, Long> {

}
