package mx.console;

import mx.console.Console.OutputListener;

public interface Command {
	public void execute(OutputListener output);
}
