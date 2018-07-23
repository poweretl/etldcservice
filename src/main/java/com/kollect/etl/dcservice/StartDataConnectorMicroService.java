package com.kollect.etl.dcservice;

import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import static spark.Spark.staticFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.kollect.etl.dcservice.util.Path;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class StartDataConnectorMicroService {

  public static final String CUSTOMER_PROP = "../ictzoneconfig/loadconfig/customer.properties";
  
  public StartDataConnectorMicroService(){}

  public static void main(String[] args) {
    port(8765);
    staticFiles.location("/public");
    staticFiles.externalLocation("upload");

    get(Path.Web.HOME, (req, res) -> {
      // new ProcessTaskExecutor().executeProcess(new ProcessArgBuilder().buildArg());
      int coreCount = Runtime.getRuntime().availableProcessors();
      float freeMem = Runtime.getRuntime().freeMemory() / 1000000000f;
      float totalMem = Runtime.getRuntime().totalMemory() / 1000000000f;
      float maxMem = Runtime.getRuntime().maxMemory() / 1000000000f;
      // ExecutorService executorService = Executors.newSingleThreadExecutor();
      // Future<String> future = executorService.submit(new ProcessTaskExecutor());
      // System.out.println("Message returned");
      return "Core Count: " + coreCount + "\n" + "Free Memory: " + freeMem + "\n" + "Total Memory: " + totalMem + "\n"
          + "Max Memory: " + maxMem + "\n";
    });

    get("/executeScript1", (req, res) -> {
      // new ProcessTaskExecutor().executeProcess(new ProcessArgBuilder().buildArg());
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      Future<Integer> future = executorService.submit(new ProcessTaskExecutor());
      System.out.println("Message returned");
      return future.get();
    });


    get("/executeScript2", (req, res) -> {
      Integer result = new ProcessTaskExecutor().executeProcess(new ProcessArgBuilder().buildArg());

      System.out.println("Message returned");
      return result;
    });

    get("/hello", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("message", "Hello Thymeleaf!");
      model.put("title", "Log Monitor");
      return new ModelAndView(model, "index"); // located in resources/templates
    }, new ThymeleafTemplateEngine());
    
    
    

  }

}
