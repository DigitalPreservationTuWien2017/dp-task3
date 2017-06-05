package at.tuwien.ss17.dp.lab3.datascience.controller;

import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;
import at.tuwien.ss17.dp.lab3.datascience.service.DMPModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataModelController {
	
	private static final Logger logger = LoggerFactory.getLogger(DataModelController.class);
	
	@Autowired
	private DMPModelService dmpModelService;
	
	@RequestMapping(value="/validateDataModelInstance")
	public void validateDataModelInstance() throws DataModelInstanceValidationException{
		logger.info("Request Receive - validateDataModelInstance");
		dmpModelService.validateModelInstance();
	}



}
