package mx.console;


public interface CommandFactory {
	
	/**
	 * get the code to identify this command, eg 'dir', 'ls', ...
	 * @return
	 */
	public String getCode();
	
	public Command createCommand();
	
}
