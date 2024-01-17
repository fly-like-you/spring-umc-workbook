package umc.spring.apiPayLoad.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _OK(HttpStatus.ACCEPTED, "SUCCESS2000", "정상 요청")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}