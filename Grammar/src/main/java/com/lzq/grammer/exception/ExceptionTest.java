package com.lzq.grammer.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            try {
                throw new BrotherSonException();
            } catch (FatherException e) {
                log.info("捕获到FatherException异常");
            } catch (BrotherException e) {
                log.info("捕获到BrotherException异常");
            }
        } catch (Exception e) {
            log.info("捕获到Exception异常");
        }
    }
}
