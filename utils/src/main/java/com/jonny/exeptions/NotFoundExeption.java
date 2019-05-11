package com.jonny.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class NotFoundExeption extends RuntimeException {
    //todo exeption!
}
