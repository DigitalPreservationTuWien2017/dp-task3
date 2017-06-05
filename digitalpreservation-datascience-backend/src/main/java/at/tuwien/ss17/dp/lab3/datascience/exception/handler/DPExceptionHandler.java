package at.tuwien.ss17.dp.lab3.datascience.exception.handler;

import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DPExceptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({DataModelInstanceValidationException.class})
	@ResponseBody
	public String badRequest(HttpServletRequest req, Exception exception) {
		return exception.toString();
	}



}
