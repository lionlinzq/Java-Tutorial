package com.lzq.grammer.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class FatherException extends Exception {

    private String errorCode;

    private String errorMsg;

    public FatherException() {
    }

    public FatherException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        log.info("FatherException异常被捕获,errorCode: {}, errorMsg: {}", errorCode, errorMsg);
    }

}
