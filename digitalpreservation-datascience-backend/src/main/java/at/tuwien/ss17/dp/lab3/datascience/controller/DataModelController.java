package at.tuwien.ss17.dp.lab3.datascience.controller;

import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.json.DmpModel;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.json.LinkDataArray;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.json.NodeDataArray;
import at.tuwien.ss17.dp.lab3.datascience.service.DMPModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
public class DataModelController {
	
	private static final Logger logger = LoggerFactory.getLogger(DataModelController.class);
	
	@Autowired
	private DMPModelService dmpModelService;

	@RequestMapping(value = "/validateDataModelInstance", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "*")
	public DmpModel validateDataModelInstance(@RequestBody String xml, HttpServletResponse response) throws DataModelInstanceValidationException{
		logger.info("Request Receive - validateDataModelInstance");
		return dmpModelService.validateAndUnmarshalModelInstance(xml);
	}



}
