package mx.console;

public interface OutputListener {
	public void onNewLine(String line);
	public void onError(Throwable t);
}