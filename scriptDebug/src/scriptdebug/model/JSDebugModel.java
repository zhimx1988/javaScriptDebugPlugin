package scriptdebug.model;

import java.io.File;
import java.io.IOException;

import scriptdebug.actions.Config;
import scriptdebug.lifecyclemanage.ClientProcess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JSDebugModel {

	private IpModel ipModel;
	private BrowserModel browserModel;
	private int deep;
	private int status;
	private int time;
	private static String recordFilePath = "AutoRecord.jar";
	private static String replayFIlePath = "DetectReplay.jar";

	public IpModel getIpModel() {
		return ipModel;
	}

	public void setIpModel(IpModel ipModel) {
		this.ipModel = ipModel;
	}

	public BrowserModel getBrowserModel() {
		return browserModel;
	}

	public void setBrowserModel(BrowserModel browserModel) {
		this.browserModel = browserModel;
	}

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public JSDebugModel(IpModel ip, BrowserModel browser) {
		this.ipModel = ip;
		this.browserModel = browser;
	}

	public DebugInfoModel executeStartCommand() {		
		File directory = new File("jsDebugPlugins");
		File[] list = directory.listFiles();
		DebugInfoModel result = new DebugInfoModel();
		if (!checkNeedJarFile(list)) {
			result.setSuccess(false);
			result.setFailMessage(new String[]{"缺少启动脚本调试进程的jar文件"});
			return result;
		}
		Gson gson = new Gson();
		String debugInfoModel = gson.toJson(this);
		/*ObjectMapper objectMapper=new ObjectMapper();
		String debugInfoModel = null;
		try {
			debugInfoModel = objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}*/
		
		debugInfoModel=debugInfoModel.replaceAll("\"","\\\\\"");
		//debugInfoModel="\""+debugInfoModel+"\"";
		
		
		Config.printToConsole(debugInfoModel, true, false);
		Runtime run = Runtime.getRuntime();
		String cmdText = "";
		Process recordProcess = null;
		Process replayProcess = null;		
		for (File a : list) {
			if (a.getName().equals(recordFilePath)) {
				cmdText = "java -jar " + a.getAbsolutePath() + " "
						+ debugInfoModel;
				Config.printToConsole(cmdText, true, false);
				try {
					recordProcess = run.exec(cmdText);
					ClientProcess.setRecorderClientProcess(recordProcess);
					ClientProcess.startRecordProcess();
					
				} catch (IOException e) {
					ClientProcess.setNull();
					result.setSuccess(false);
					result.setFailMessage(new String[]{"[recordClient]"+e.getMessage(),"start recordClient fail"});
					return result;
				}
			} else if (a.getName().equals(replayFIlePath)) {
				cmdText = "java -jar " + a.getAbsolutePath() + " "
						+ debugInfoModel;
				Config.printToConsole(cmdText, true, false);
				try {
					replayProcess = run.exec(cmdText);
					ClientProcess.setReplayClienyProcess(replayProcess);
					ClientProcess.startReplayProcess();
				} catch (IOException e) {
					ClientProcess.setNull();
					result.setSuccess(false);
					result.setFailMessage(new String[]{"[replayClient]"+e.getMessage(),"start replayClient fail"});
					return result;
				}
			}
		}
		result.setSuccess(true);
		return result;
	}

	protected static boolean checkNeedJarFile(File[] files) {
		int jarFileNum = 0;
		if(files==null||files.length==0)
			return false;
		for (File file : files) {
			if (file.getName().equals(recordFilePath)
					|| file.getName().equals(replayFIlePath)) {
				jarFileNum++;
			}
		}
		if (jarFileNum == 2)
			return true;
		else {
			return false;
		}
	}
}
