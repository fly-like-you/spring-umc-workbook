package umc.spring.apiPayLoad.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ReasonDTO {
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public ReasonDTO(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
