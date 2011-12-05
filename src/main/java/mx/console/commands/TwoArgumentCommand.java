/*******************************************************************************
 * Copyright 2011 Max Erik Rohde http://www.mxro.de
 * 
 * All rights reserved.
 ******************************************************************************/
package mx.console.commands;

public interface TwoArgumentCommand<GArgument1, GArgument2> extends OneArgumentCommand<GArgument1> {
	
	/**
	 * returns false if the string is invalid.
	 * @param argument
	 * @return
	 */
	public boolean setArgument2(String argument);
	
	public GArgument2 getArgument2();
	
}
