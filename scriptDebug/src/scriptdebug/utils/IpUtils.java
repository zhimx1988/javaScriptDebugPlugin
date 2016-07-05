package scriptdebug.utils;

import javax.swing.JTable;

import scriptdebug.model.IpModel;

public class IpUtils extends Utils {
	public static IpModel createIpModel(JTable ipTable) {
		IpModel ip = new IpModel();
		for(int i=0;i<ipTable.getRowCount();i++){			
			if(ipTable.getValueAt(i, 0).toString().equals("Web服务器"))
				ip.setWebIp(ipTable.getValueAt(i, 1).toString());
			else if(ipTable.getValueAt(i, 0).toString().equals("数据服务器"))
				ip.setServerIp(ipTable.getValueAt(i, 1).toString());
			else if(ipTable.getValueAt(i, 0).toString().equals("代理服务器"))
				ip.setProxyIp(ipTable.getValueAt(i, 1).toString());
			else if(ipTable.getValueAt(i, 0).toString().equals("本地IP"))
				ip.setAnalysisIp(ipTable.getValueAt(i, 1).toString());
			else
				return null;
		}
		return ip;
	}
}
