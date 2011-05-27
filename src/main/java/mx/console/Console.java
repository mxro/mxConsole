package mx.console;

import java.util.ArrayList;
import java.util.List;

import mx.console.internal.BasicCommandInterpreter;

/**
 * Interface for console like string-based interactions.
 * 
 * @author Max
 *
 */
public class Console implements OutputListener {
	
	private final BasicCommandInterpreter interpreter;
	private final List<OutputListener> listener;
	
	public void execute(final String command) {
		final Command interpreted = interpreter.interpret(command);
		interpreted.execute(this);
	}
	
	public void addCommand(final CommandFactory commandFactory) {
		interpreter.addCommand(commandFactory);
	}
	
	public void addOutputListener(final OutputListener outputListener) {
		this.listener.add(outputListener);
	}

	@Override
	public void onNewLine(final String line) {
		for (final OutputListener ol : this.listener) {
			ol.onNewLine(line);
		}
	}

	@Override
	public void onError(final Throwable t) {
		for (final OutputListener ol : this.listener) {
			ol.onError(t);
		}
	}

	public Console() {
		super();
		this.interpreter = new BasicCommandInterpreter();
		this.listener = new ArrayList<OutputListener>();
	}
	
	
}
