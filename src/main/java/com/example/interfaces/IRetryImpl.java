package com.example.interfaces;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Slot;
import com.example.repos.ISlotRepo;

@Service
public class IRetryImpl implements IRetry {

	@Autowired

	ISlotRepo iSlotRepo;

	@Override
	public void save(Slot slot) {
		iSlotRepo.save(slot);

	}

	@Override
	public String getAlertFallback(SQLException e, String param1, String param2) {
		return "sensor service is down, please check";
	}

}
