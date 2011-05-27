package mx.console.commands;

public interface OneArgumentCommand<GArgument1> extends ZeroArgumentCommand {
	
	/**
	 * returns false if the string is invalid.
	 * @param argument
	 * @return
	 */
	public boolean setArgument1(String argument);
	
	public GArgument1 getArgument1();
	
}
