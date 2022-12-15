package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.model.Plot;
import com.example.repos.IPlotRepo;
import com.example.repos.ISlotRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class AISTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private IPlotRepo iPlotRepo;

	@MockBean
	private ISlotRepo iSlotRepo;

	// Save Plot to a land
	@Test
	public void savePlot() throws Exception {

		// given - precondition or setup
		Plot plot = new Plot();
		plot.setArea_ha(3142);
		plot.setCity("CHD");
		plot.setDistrict("CHD");
		plot.setState("CHD");
		plot.setIrrigationReq(false);
		plot.setRegisteredOwner("MRC");
		plot.setUnit_price(500000);
		given(iPlotRepo.save(any(Plot.class))).willAnswer((invocation) -> invocation.getArgument(0));

		// when - action or behaviour that we are going test
		ResultActions response = mockMvc.perform(post("/api/v1/plot").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(plot)));

		// then - verify the result or output using assert statements
		response.andDo(print()).andExpect(status().isCreated())
				.andExpect(jsonPath("$.registeredOwner", is(plot.getRegisteredOwner())));

	}

	// Update Plot details
	@Test
	public void updatePlot() throws Exception {

		// given - precondition or setup

		long plotId = 1L;

		Plot savedPlot = new Plot();
		savedPlot.setArea_ha(3142);
		savedPlot.setCity("CHD");
		savedPlot.setDistrict("CHD");
		savedPlot.setState("CHD");
		savedPlot.setIrrigationReq(false);
		savedPlot.setRegisteredOwner("MRC");
		savedPlot.setUnit_price(500000);

		Plot updatedPlot = new Plot();
		updatedPlot.setArea_ha(3142);
		updatedPlot.setCity("Chandigarh");
		updatedPlot.setDistrict("Chandigarh");
		updatedPlot.setState("Chandigarh");
		updatedPlot.setIrrigationReq(false);
		updatedPlot.setRegisteredOwner("MRC");
		updatedPlot.setUnit_price(500000);

		given(iPlotRepo.findById(plotId)).willReturn(Optional.of(savedPlot));
		given(iPlotRepo.save(any(Plot.class))).willAnswer((invocation) -> invocation.getArgument(0));

		// when - action or behaviour that we are going test
		ResultActions response = mockMvc.perform(put("/api/v1/plot/{id}", plotId)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedPlot)));

		// then - verify the result or output using assert statements
		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.city", is(updatedPlot.getCity())));

	}

	// Configure Plot
	@Test
	public void configurePlot() throws Exception {

		// given - precondition or setup

		long plotId = 1L;

		Plot savedPlot = new Plot();
		savedPlot.setArea_ha(3142);
		savedPlot.setCity("CHD");
		savedPlot.setDistrict("CHD");
		savedPlot.setState("CHD");
		savedPlot.setIrrigationReq(false);
		savedPlot.setRegisteredOwner("MRC");
		savedPlot.setUnit_price(500000);

		Plot updatedPlot = new Plot();
		updatedPlot.setArea_ha(3142);
		updatedPlot.setCity("Chandigarh");
		updatedPlot.setDistrict("Chandigarh");
		updatedPlot.setState("Chandigarh");
		updatedPlot.setIrrigationReq(false);
		updatedPlot.setRegisteredOwner("MRC");
		updatedPlot.setUnit_price(500000);
		updatedPlot.setRegisteredByer("Munish");

		given(iPlotRepo.findById(plotId)).willReturn(Optional.of(savedPlot));
		given(iPlotRepo.save(any(Plot.class))).willAnswer((invocation) -> invocation.getArgument(0));

		// when - action or behaviour that we are going test
		ResultActions response = mockMvc.perform(put("/api/v1/configure/plot/{id}", plotId)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedPlot)));

		// then - verify the result or output using assert statements
		response.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.registeredBuyer", is(updatedPlot.getRegisteredBuyer())));

	}
	
	// Test Irrigation System
		@Test
		public void checkIrrigationSystem() throws Exception {

			// given - precondition or setup

			long plotId = 1L;

			Plot savedPlot = new Plot();
			savedPlot.setArea_ha(3142);
			savedPlot.setCity("CHD");
			savedPlot.setDistrict("CHD");
			savedPlot.setState("CHD");
			savedPlot.setIrrigationReq(false);
			savedPlot.setRegisteredOwner("MRC");
			savedPlot.setUnit_price(500000);


			given(iPlotRepo.findById(plotId)).willReturn(Optional.of(savedPlot));
			given(iPlotRepo.save(any(Plot.class))).willAnswer((invocation) -> invocation.getArgument(0));

			// when - action or behaviour that we are going test
			ResultActions response = mockMvc.perform(put("/api/v1/irrigation/{id}/{req}", plotId,true)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(savedPlot)));

			// then - verify the result or output using assert statements
			response.andDo(print()).andExpect(status().isOk())
					.andExpect(jsonPath("$.irrigationReq", is(savedPlot.isIrrigationReq())));

		}

	// Get all plot details
	@Test
	public void getPlotListAndDetails() throws Exception {

		Plot plot = new Plot();
		plot.setArea_ha(3142);
		plot.setCity("CHD");
		plot.setDistrict("CHD");
		plot.setState("CHD");
		plot.setIrrigationReq(false);
		plot.setRegisteredOwner("MRC");
		plot.setUnit_price(500000);

		Plot plot1 = new Plot();
		plot1.setArea_ha(3142);
		plot1.setCity("Bangaore");
		plot1.setDistrict("bangalore");
		plot1.setState("karnataka");
		plot1.setIrrigationReq(false);
		plot1.setRegisteredOwner("Shobha");
		plot1.setUnit_price(750000);

		List<Plot> listOfPlots = new ArrayList<>();
		listOfPlots.add(plot);
		listOfPlots.add(plot1);

		given(iPlotRepo.findAll()).willReturn(listOfPlots);

		ResultActions response = mockMvc.perform(get("/api/v1/plots"));

		// then - verify the output
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(listOfPlots.size())));

	}

}
