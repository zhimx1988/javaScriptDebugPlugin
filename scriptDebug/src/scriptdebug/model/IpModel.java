package scriptdebug.model;

public class IpModel {
	private String webIp;
	private String serverIp;
	private String proxyIp;
	private String localIp;

	public String getAnalysisIp() {
		return localIp;
	}

	public void setAnalysisIp(String localIp) {
		this.localIp = localIp;
	}

	public String getWebIp() {
		return webIp;
	}

	public void setWebIp(String webIp) {
		this.webIp = webIp;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getProxyIp() {
		return proxyIp;
	}

	public void setProxyIp(String proxyIp) {
		this.proxyIp = proxyIp;
	}
	
	public String toString(){
		return "WebIP:"+webIp+"\n"+"ServerIP:"+serverIp+"\n"+"ProxyIP:"+proxyIp+"\n"+"AnaIp:"+localIp;
	}

}
