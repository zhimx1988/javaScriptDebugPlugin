package console.message;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;


	public class ConsoleFactory implements IConsoleFactory {

	    //static MessageConsole console = new MessageConsole("javascript", null);
		private static MessageConsole console=new MessageConsole("javaScript", null);
	    
	    public ConsoleFactory(){

	    }
	   
	    public void openConsole() {
	        showConsole();
	    }
	    public void showConsole() {
	       if (console != null) {
	         IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
	         IConsole[] existing = manager.getConsoles();
	         boolean exists = false;
	         for (int i = 0; i < existing.length; i++) {
	           if (console == existing[i])
	               exists = true;
	         }
	         if (!exists) {
	           manager.addConsoles(new IConsole[] { console });
	         }
	         manager.showConsoleView(console);
	   
	         /*MessageConsoleStream stream = console.newMessageStream();
	         try {
	            stream.write("����!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	         System.setOut(new PrintStream(stream));*/
	       }
	    }
	    public void closeConsole() {
	       IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
	       if (console != null) {
	         manager.removeConsoles(new IConsole[] { console });
	       }
	    }
	   
	    public MessageConsole getConsole() {
	       return console;
	    }
	}

