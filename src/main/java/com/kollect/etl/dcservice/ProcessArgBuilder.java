package com.kollect.etl.dcservice;

import java.util.ArrayList;
import java.util.List;

public class ProcessArgBuilder {
  
  public List<String> buildArg(){
    final String scriptPath = "/media/joshua/martian/kvworkspace/dataconnector-mahb/bin/";
    String script = "execute.sh";
    List<String> command = new ArrayList<>();
    command.add("/bin/bash");
    command.add(scriptPath + script);
    command.add("-c");
    command.add("../ictzoneconfig/loadconfig/invoice.properties");
    return command;
  }
  
  

}
