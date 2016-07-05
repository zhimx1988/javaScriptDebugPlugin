package scriptdebug.model;

import java.util.ArrayList;

public class BrowserModel {
	private ArrayList<SingleBrowserModel> browsers = new ArrayList<SingleBrowserModel>();

	public void addBrowser(SingleBrowserModel singleBrowserModel) {
		browsers.add(singleBrowserModel);
	}

	public ArrayList<SingleBrowserModel> getBrowsers() {
		return this.browsers;
	}

	public String toString() {
		String string = "";
		for (SingleBrowserModel singleBrowserModel : browsers) {
			string += "browser:" + singleBrowserModel.getBrowser() + " dir:"
					+ singleBrowserModel.getDir() + " os:"
					+ singleBrowserModel.getOs() + " os_bit:"
					+ singleBrowserModel.getOsBit() + "\n";
		}
		return string;
	}
}
