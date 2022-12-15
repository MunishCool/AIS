package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Plot;
import com.example.repos.IPlotRepo;

@RestController
@RequestMapping(value = "/api/v1")
public class PlotLandController {

	@Autowired
	IPlotRepo iPlotRepo;

	@PostMapping("/plot")
	public ResponseEntity<Plot> savePlot(@RequestBody Plot Plot) {
		try {
			return new ResponseEntity<>(iPlotRepo.save(Plot), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/plot/{id}")
	public ResponseEntity<Plot> updatePlot(@RequestBody Plot Plot, @PathVariable Long id) {
		try {
			Optional<Plot> plotOptional = iPlotRepo.findById(id);

			if (plotOptional.isPresent()) {
				{
					return new ResponseEntity<>(iPlotRepo.save(Plot), HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/configure/plot/{id}")
	public ResponseEntity<Plot> configurePlot(@RequestBody Plot Plot, @PathVariable Long id) {
		try {
			Optional<Plot> plotOptional = iPlotRepo.findById(id);

			if (plotOptional.isPresent()) {
				{
					return new ResponseEntity<>(iPlotRepo.save(Plot), HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/plots")
	public ResponseEntity<List<Plot>> getAllPlots() {
		try {
			List<Plot> list = iPlotRepo.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
