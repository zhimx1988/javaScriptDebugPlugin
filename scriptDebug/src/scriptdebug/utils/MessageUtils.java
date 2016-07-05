package scriptdebug.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import scriptdebug.actions.Config;

public class MessageUtils extends Utils {
	public static boolean recordFinish = false;
	public static boolean replayFinish = false;

	public static void convertRecordStreamToString(Process recordProcess) {
		InputStream in = recordProcess.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		recordFinish=false;
		try {
			while (!recordFinish) {
				line = reader.readLine();
				if (line != null)
					Config.printToConsole("[recordClient]" + reader.readLine(),
							true, false);
				else {
					Thread.sleep(1000);
				}
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			//Config.printToConsole(e.getMessage(), true, false);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				Config.printToConsole(e.getMessage(), true, false);
			}
		}
	}

	public static void convertReplayStreamToString(Process replayProcess) {
		InputStream in = replayProcess.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		replayFinish=false;
		try {
			while (!replayFinish) {
				line = reader.readLine();
				if (line != null)
					Config.printToConsole("[replayClient]" + reader.readLine(),
							true, false);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Config.printToConsole(e.getMessage(), true, false);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				Config.printToConsole(e.getMessage(), true, false);
			}
		}
	}
}
