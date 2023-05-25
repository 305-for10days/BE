package jy.demo.exception;

import jy.demo.common.HttpResponse;

public class BadRequestException extends RuntimeException {

    private final HttpResponse httpResponse;

    public BadRequestException(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }
}
