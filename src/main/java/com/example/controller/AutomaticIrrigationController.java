package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interfaces.IRetry;
import com.example.model.Plot;
import com.example.model.Slot;
import com.example.repos.IPlotRepo;
import com.example.repos.ISlotRepo;

@RestController
@RequestMapping(value = "/api/v1")
public class AutomaticIrrigationController {

	@Autowired
	IPlotRepo iPlotRepo;

	@Autowired

	ISlotRepo iSlotRepo;
	
	@Autowired
	IRetry iRetry;

	@PutMapping("/irrigation/{id}/{req}")
	public ResponseEntity<Plot> chooseSlot(@PathVariable Long id, @PathVariable boolean req) {
		try {
			Optional<Plot> plotOptional = iPlotRepo.findById(id);

			if (plotOptional.isPresent()) {
				Plot plot = plotOptional.get();
				if (req) {
					plot.setIrrigationReq(req);
					
					// Update the status of the slot
					Slot slot = new Slot();
					slot.setSlotAssigned(req);
					iRetry.save(slot);
				}
				return new ResponseEntity<>(iPlotRepo.save(plot), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
