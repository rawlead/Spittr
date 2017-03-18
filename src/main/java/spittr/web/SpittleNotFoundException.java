package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP Status 404 - Spittlee Not Found
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittlee Not Found")
public class SpittleNotFoundException  extends RuntimeException {
}
