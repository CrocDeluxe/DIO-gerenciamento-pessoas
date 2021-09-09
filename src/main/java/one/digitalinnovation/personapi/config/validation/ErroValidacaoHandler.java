package one.digitalinnovation.personapi.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormularioDto> handler(MethodArgumentNotValidException exception) {
        List<ErroFormularioDto> dto = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult()
                .getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroFormularioDto error = new ErroFormularioDto(e.getField(), message);
            dto.add(error);
        });
        return dto;
    }

//    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(HttpServerErrorException.class)
//    public ErroDeFormularioDto handler2(HttpServerErrorException errorException) {
//        ErroDeFormularioDto error = new ErroDeFormularioDto(errorException.getMessage());
//        return error;
//    }

}
