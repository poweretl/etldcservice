package com.kollect.etl.dcservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;

public class ProcessTaskExecutor  implements Callable<String> {
  
  // interpreter, Path, script name,
  public void executeProcess(List<String> processArgs) throws IOException, InterruptedException {
    Process p = new ProcessBuilder(processArgs).start();
    System.out.println("Executing thread " + Thread.currentThread().getName());
    int waitTime = p.waitFor();
    if (waitTime == 0) {
      System.out.println("Successful execution");
    } else {
      System.out.println("Failure, an error occurred");
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
      String line = "";
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }

  @Override
  public String call() throws Exception {
    Process p = new ProcessBuilder(new ProcessArgBuilder().buildArg()).start();
    System.out.println("Executing thread " + Thread.currentThread().getName());
    int waitTime = p.waitFor();
    String message = null;
    if (waitTime == 0) {
      message = "Successful execution";
      System.out.println(message);
      return message;
    } else {
      message = "Failure, an error occurred";
      System.out.println(message);
      return message;
    }
  }

}
