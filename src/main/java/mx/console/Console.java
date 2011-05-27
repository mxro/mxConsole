package mx.console;

/**
 * Interface for console like string-based interactions.
 * 
 * @author Max
 *
 */
public interface Console<GCommand extends CommandFactory> {
	
	public static interface OutputListener {
		public void onNewLine(String line);
		public void onError(Throwable t);
	}
	
	public void execute(GCommand command);
	public void print(String output);
	
	public void addOutputListener(OutputListener listener);
}
