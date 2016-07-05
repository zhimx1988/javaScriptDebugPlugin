package scriptdebug.model;

public class DebugInfoModel {
	boolean success;
	String[] failMessage;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String[] getFailMessage() {
		return failMessage;
	}
	public void setFailMessage(String[] failMessage) {
		this.failMessage = failMessage;
	}

}
