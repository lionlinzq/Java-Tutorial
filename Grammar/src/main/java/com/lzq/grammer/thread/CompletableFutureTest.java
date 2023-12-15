package com.lzq.grammer.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("1");
            return "hello";
        }).thenApply(s -> {
            System.out.println("2");
            return s + " world";
        }).thenApply(s -> {
            System.out.println("3");
            return s + "!";
        });
        future.thenAccept(s -> {
            System.out.println(s);
        });
        future.exceptionally(e -> {
            System.out.println(e);
            return "error";
        });
    }
}
