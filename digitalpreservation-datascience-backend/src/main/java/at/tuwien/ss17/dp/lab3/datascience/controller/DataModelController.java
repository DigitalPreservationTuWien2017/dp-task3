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
		DmpModel dmpModel = dmpModelService.validateAndUnmarshalModelInstance(xml);

		//TODO remove
        /*dmpModel = new DmpModel();
        dmpModel.setNodeKeyProperty("id");

        List<NodeDataArray> ndaList = new ArrayList<>();
        NodeDataArray nda = new NodeDataArray();
        nda.setId(0);
        nda.setLoc("120 120");
        nda.setText("Initial");
        ndaList.add(nda);
        nda = new NodeDataArray();
        nda.setId(1);
        nda.setLoc("330 120");
        nda.setText("First down");
        ndaList.add(nda);

        dmpModel.setNodeDataArray(ndaList);

        List<LinkDataArray> ldaList = new ArrayList<>();
        LinkDataArray lda = new LinkDataArray();
        lda.setFrom(0);
        lda.setTo(0);
        lda.setText("up or timer");
        lda.setCurviness(-20);
        ldaList.add(lda);
        lda = new LinkDataArray();
        lda.setFrom(0);
        lda.setTo(1);
        lda.setText("down");
        lda.setCurviness(10);
        ldaList.add(lda);

        dmpModel.setLinkDataArray(ldaList);*/



		return dmpModel;
	}



}
