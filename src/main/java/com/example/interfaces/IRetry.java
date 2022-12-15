package com.example.interfaces;

import java.sql.SQLException;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import com.example.model.Slot;

public interface IRetry {

	@Retryable(value = { SQLException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public void save(Slot slot);

	@Recover
	public String getAlertFallback(SQLException e, String param1, String param2);

}
