/*******************************************************************************
 * Copyright 2011 Max Erik Rohde http://www.mxro.de
 * 
 * All rights reserved.
 ******************************************************************************/
package mx.console;

public interface OutputListener {
	public void onNewLine(String line);
	public void onError(Throwable t);
}
