package scriptdebug.model;

public class SingleBrowserModel {
	private String browser;
	private String dir;
	private String os;
	private int osBit;
	
	public SingleBrowserModel(String browser,String dir,String os,int osBit){
		this.browser=browser;
		this.dir=dir;
		this.os=os;
		this.osBit=osBit;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getOsBit() {
		return osBit;
	}

	public void setOsBit(int osBit) {
		this.osBit = osBit;
	}
}
