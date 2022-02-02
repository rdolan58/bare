package com.freddiemac.dropbox.controller;

import com.freddiemac.dropbox.dto.CounterPartyDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @author f404127 (Ray Dolan)
 */
@RestController
@RequestMapping("/fmdropbox")
public class CounterPartyController {

	final Logger logger = LoggerFactory.getLogger(CounterPartyController.class);

    
	@GetMapping(value = "/counterparty",
       	 		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CounterPartyDTO> getCounterParty(@RequestParam(value = "id", required = true) String id) {

    	logger.info("Received get request for /counterparty: {}", id);

		CounterPartyDTO counterPartyDTO = new CounterPartyDTO();
		counterPartyDTO.setActive(true);
		counterPartyDTO.setCounterPartyRegisteredId("rid1");
		counterPartyDTO.setCpRegisteredName("rn1");
		counterPartyDTO.setId("p101010");

		logger.info("CounterParty found {}", counterPartyDTO.toString());
		return new ResponseEntity<>(counterPartyDTO, HttpStatus.OK);
	}


}
