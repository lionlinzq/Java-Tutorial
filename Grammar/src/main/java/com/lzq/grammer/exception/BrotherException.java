package com.lzq.grammer.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class BrotherException extends FatherException {

    private String errorCode;

    private String errorMsg;

    public BrotherException() {
    }

    public BrotherException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        log.info("BrotherException异常被捕获,errorCode: {}, errorMsg: {}", errorCode, errorMsg);
    }

}
