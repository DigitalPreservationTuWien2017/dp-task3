package at.tuwien.ss17.dp.lab3.datascience.service;

import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;


public interface DMPModelService {

    void validateModelInstance () throws DataModelInstanceValidationException;

}
