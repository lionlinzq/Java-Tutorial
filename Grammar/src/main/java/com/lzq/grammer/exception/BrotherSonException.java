package com.lzq.grammer.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class BrotherSonException extends BrotherException {

    private String errorCode;

    private String errorMsg;

    public BrotherSonException() {
    }

    public BrotherSonException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        log.info("BrotherSonException异常被捕获,errorCode: {}, errorMsg: {}", errorCode, errorMsg);
    }

}
