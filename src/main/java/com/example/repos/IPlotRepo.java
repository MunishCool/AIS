package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Plot;

public interface IPlotRepo extends JpaRepository<Plot, Long> {

}
