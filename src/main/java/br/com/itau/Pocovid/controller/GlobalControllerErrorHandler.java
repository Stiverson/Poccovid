package br.com.itau.Pocovid.controller;

import br.com.itau.Pocovid.exceptions.ServiceException;
import br.com.itau.Pocovid.exceptions.UtilsException;
import br.com.itau.Pocovid.model.BaseResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerErrorHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalControllerErrorHandler.class);
    private final Map<Class<? extends ServiceException>, HttpStatus> statusMap;

    public GlobalControllerErrorHandler() {
        this.statusMap = new HashMap<>();
        this.statusMap.put(UtilsException.class, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse exceptionHandler(Exception exception, HttpServletRequest request) {
        LOGGER.error("Erro interno", exception);
        return BaseResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno, por favor contate o suporte.");
    }

    @ExceptionHandler(UtilsException.class)
    public ResponseEntity<BaseResponse> economiaAPIExceptionHandler(UtilsException exception) {
        LOGGER.error("Erro ao validar dados", exception);
        final HttpStatus status = statusMap.get(exception.getClass());
        return ResponseEntity
                .status(status)
                .body(BaseResponse.error(status, exception.getMessage()));
    }


}
