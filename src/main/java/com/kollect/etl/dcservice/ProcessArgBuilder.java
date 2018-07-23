package com.kollect.etl.dcservice;

import java.util.ArrayList;
import java.util.List;

public class ProcessArgBuilder {
  
  public List<String> buildArg(){
    final String scriptPath = "/media/joshua/martian/kvworkspace/dataconnector-mahb/bin/";
    final String scriptName = "execute.sh";
    final List<String> arg = new ArrayList<>();
    arg.add("/bin/bash");
    arg.add(scriptPath + scriptName);
    arg.add("-c");
    arg.add("../ictzoneconfig/loadconfig/invoice.properties");
    return arg;
  }
  
  

}
