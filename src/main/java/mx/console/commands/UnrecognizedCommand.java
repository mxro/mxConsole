/*******************************************************************************
 * Copyright 2011 Max Erik Rohde http://www.mxro.de
 * 
 * All rights reserved.
 ******************************************************************************/
package mx.console.commands;

import mx.console.Command;
import mx.console.OutputListener;

public class UnrecognizedCommand implements Command {
	
	private final String message;
	
	public String getErrorMessage() {
		return message;
	}

	public UnrecognizedCommand(final String message) {
		super();
		this.message = message;
	}

	@Override
	public void execute(final OutputListener output) {
		output.onError(new Throwable(message));
	}
	
	
}
