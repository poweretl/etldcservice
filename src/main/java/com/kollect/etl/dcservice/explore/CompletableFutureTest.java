package com.kollect.etl.dcservice.explore;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {



    //running asynchronous computation using async
    public void asyncComputation() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> futureResult = CompletableFuture.runAsync(() -> {

                try{
                    TimeUnit.SECONDS.sleep(10);
                }
                catch(InterruptedException inter){
                    System.out.println("Some shit happened!");

                }
        });

        futureResult.get();
    }


    public static void main(String[] args) throws Exception{
        new CompletableFutureTest().asyncComputation();
    }

}
