
package edu.hacks.good.CommandHandler;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import edu.hacks.good.SystemCommand;

public class FileHandler implements CommandHandler {

	private static final String WINDOWS = "cmd";
//		private static final String UNIX = "bash";
//		private static String os = System.getProperty("os.name");
	private static String fileServicePath = System.getProperty("user.home")+"/remote_twitter/services";
	private static String fileLogPath = System.getProperty("user.home") + "/remote_twitter/logs";
	
	private static void executeCommand() {
		try{    
		    Process p = Runtime.getRuntime().exec(WINDOWS + fileServicePath + "start" + fileName);
		    p.waitFor();
	
		}catch( IOException ex ){
		    //Validate the case the file can't be accesed (not enought permissions)
			System.out.println("file could not be found");
	
		}catch( InterruptedException ex ){
		    //Validate the case the process is being stopped by some external situation     
			System.out.println("command was not able to execute");
		}
	}
	
	private List<File> searchForFile(File rootDirectory, FileFilter filter){
	    List<File> results = new ArrayList<File>();
	    for(File currentItem : rootDirectory.listFiles(filter)){
	      if(currentItem.isDirectory()){
	          results.addAll(searchForFile(currentItem, filter));
	      }
	      else{
	          results.add(currentItem);
	      }
	    }
	    return results;
	}
	
	private static void createLogFile() throws IOException {
		File f = new File(fileLogPath + ".txt");
		f.mkdirs(); 
		f.createNewFile();
	}

	@Override
	public SystemCommand getCommandType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleCommand(Status status) {
		// TODO Auto-generated method stub
			
		}
	}

}
