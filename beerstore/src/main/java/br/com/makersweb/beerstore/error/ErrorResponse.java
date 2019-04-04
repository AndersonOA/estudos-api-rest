package br.com.makersweb.beerstore.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * @author aaristides
 */
@JsonAutoDetect(fieldVisibility = ANY)
public class ErrorResponse {

    @NonNull
    private final int statusCode;

    @NonNull
    private final List<ApiError> erros;

    public ErrorResponse(int statusCode, List<ApiError> erros) {
        this.statusCode = statusCode;
        this.erros = erros;
    }

    static ErrorResponse of(HttpStatus status, List<ApiError> errors) {
        return new ErrorResponse(status.value(), errors);
    }

    static ErrorResponse of(HttpStatus status, ApiError error) {
        return of(status, Collections.singletonList(error));
    }


    @JsonAutoDetect(fieldVisibility = ANY)
    static class ApiError {

        @NonNull
        private final String code;

        @NonNull
        private final String message;

        public ApiError(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }

}
