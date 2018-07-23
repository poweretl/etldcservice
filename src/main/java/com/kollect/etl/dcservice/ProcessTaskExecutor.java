package com.kollect.etl.dcservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;

public class ProcessTaskExecutor  implements Callable<Integer> {

  private static final Logger LOG = LoggerFactory.getLogger(ProcessTaskExecutor.class);


  public int getExecutionStatus(final int waitTime){
    String message;
    if (waitTime == 0) {
      message = "Successful execution";
      LOG.debug("{}",message);
    } else {
      message = "Failure, an error occurred";
      LOG.debug("{}",message);
    }
    return waitTime;
  }


  public Integer executeProcess(List<String> processArgs) throws IOException, InterruptedException {
    Process p = new ProcessBuilder(processArgs).start();
    System.out.println("Executing thread " + Thread.currentThread().getName());
    return getExecutionStatus(p.waitFor());
  }

  @Override
  public Integer call() throws IOException, InterruptedException {
    Process p = new ProcessBuilder(new ProcessArgBuilder().buildArg()).start();
    System.out.println("Executing thread " + Thread.currentThread().getName());
    int waitTime = p.waitFor();
    return getExecutionStatus(waitTime);

  }

}
