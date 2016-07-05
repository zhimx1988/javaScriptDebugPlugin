package scriptdebug.utils;

import javax.swing.JTable;

import scriptdebug.model.BrowserModel;
import scriptdebug.model.SingleBrowserModel;

public class BrowserUtils extends Utils {
	public static BrowserModel createBrowserModel(JTable browserTable) {
		BrowserModel browser = new BrowserModel();
		int rowNumber = browserTable.getRowCount();
		for (int i = 0; i < rowNumber; i++) {
			browser.addBrowser(new SingleBrowserModel(browserTable.getValueAt(
					i, 0).toString(), browserTable.getValueAt(i, 1).toString(),
					browserTable.getValueAt(i, 2).toString(), Integer
							.parseInt(browserTable.getValueAt(i, 3).toString())));

		}
		return browser;

	}

}
