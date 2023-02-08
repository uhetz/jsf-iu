package de.northcodes.course.jsfspring.commons;

import org.springframework.http.HttpStatus;

public class WebAppException extends Exception {
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public WebAppException(WEBAPP_ERROR error) {
        super(error.code + ": " + error.msg);
        httpStatus = error.status;
    }

    public WebAppException(WEBAPP_ERROR error, String additional_msg) {
        super(error.code + ": " + error.msg + " " + additional_msg);
        httpStatus = error.status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public enum WEBAPP_ERROR {
        DISTRICT_NOT_FOUND(100, HttpStatus.NOT_FOUND, "District object(s) wasn't (weren't) find in the database."),
        SORTING_PARAMETER_IS_NOT_ALLOWED(101, HttpStatus.BAD_REQUEST, "Sorting parameter was used that is not allowed. Check documentation."),
        VOTE_NOT_FOUND(200, HttpStatus.NOT_FOUND, "Vote object(s) wasn't (weren't) find in the database.");
        private final int code;
        private final HttpStatus status;
        private final String msg;

        WEBAPP_ERROR(int code, HttpStatus status, String msg) {
            this.code = code;
            this.status = status;
            this.msg = msg;
        }
    }
}
