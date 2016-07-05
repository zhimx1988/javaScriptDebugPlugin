package scriptdebug.lifecyclemanage;

import scriptdebug.utils.MessageUtils;

public class ClientProcess {
private static Process recorderClientProcess=null;
private static Process replayClientProcess=null;
public static Process getRecorderClientProcess() {
	return recorderClientProcess;
}
public static void setRecorderClientProcess(Process recorderClientProcess) {
	ClientProcess.recorderClientProcess = recorderClientProcess;
}
public static Process getReplayClienyProcess() {
	return replayClientProcess;
}
public static void setReplayClienyProcess(Process replayClienyProcess) {
	ClientProcess.replayClientProcess = replayClienyProcess;
}

public static void setNull(){
	if(recorderClientProcess!=null){
		recorderClientProcess.destroy();
		recorderClientProcess=null;
	}
	if(replayClientProcess!=null){
		replayClientProcess.destroy();
		replayClientProcess=null;
	}
/*	MessageUtils.recordFinish=false;
	MessageUtils.replayFinish=false;*/
}

public static void startRecordProcess(){
	Thread readInputStream = new Thread("read record inputStream") {
		public void run() {
			MessageUtils.convertRecordStreamToString(recorderClientProcess);
		}
	};
	Thread listenProcessStatus = new Thread("listen record process status") {
		public void run() {
			try {
				recorderClientProcess.waitFor();

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				MessageUtils.recordFinish = true;
			}
		}
	};
	readInputStream.start();
	listenProcessStatus.start();
}

public static void startReplayProcess(){
	Thread readInputStream = new Thread("read replay inputStream") {
		public void run() {
			MessageUtils.convertReplayStreamToString(replayClientProcess);
		}
	};
	Thread listenProcessStatus = new Thread("listen replay process status") {
		public void run() {
			try {
				replayClientProcess.waitFor();

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				MessageUtils.replayFinish = true;
			}
		}
	};
	readInputStream.start();
	listenProcessStatus.start();
}

}
