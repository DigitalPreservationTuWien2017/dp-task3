package at.tuwien.ss17.dp.lab3.datascience.service;

import at.tuwien.ss17.dp.lab3.datascience.model.dmp.json.DmpModel;
import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;


public interface DMPModelService {

    DmpModel validateAndUnmarshalModelInstance(String xml) throws DataModelInstanceValidationException;

}
