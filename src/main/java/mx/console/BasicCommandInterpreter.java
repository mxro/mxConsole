package mx.console;

import java.util.HashMap;
import java.util.Map;

import mx.console.commands.OneArgumentCommand;
import mx.console.commands.TwoArgumentCommand;
import mx.console.commands.UnrecognizedCommand;

public class BasicCommandInterpreter {

	public final Map<String, CommandFactory> commands;

	public void addCommand(final CommandFactory commandFactory) {
		commands.put(commandFactory.getCode(), commandFactory);
	}
	
	public Command interpret(final String line) {
		if (line == null) {
			return new UnrecognizedCommand("Cannot interpret command <null>.");
		}
		final String[] split = line.split(" ");

		if (split.length < 1) {
			return new UnrecognizedCommand("Command too short [" + line + "].");
		}

		if (!commands.containsKey(split[0])) {
			return new UnrecognizedCommand("No command [" + split[0]
					+ "] registered. Cannot interpret [" + line + "].");
		}

		final Command command = commands.get(split[0]).createCommand();

		if (split.length == 1) {
			return command;
		}

		if (split.length == 2) {
			if ((command instanceof OneArgumentCommand)) {
				final OneArgumentCommand<?> oneArgumentCommand = (OneArgumentCommand<?>) command;
				if (!oneArgumentCommand.setArgument1(split[1])) {
					return new UnrecognizedCommand("First argument invalid ["
							+ split[1] + "]. Cannot interpret command [" + line
							+ "]");
				}
				return command;
			}

		}

		if (split.length == 3) {
			if ((command instanceof TwoArgumentCommand)) {
				final TwoArgumentCommand<?, ?> twoArgumentCommand = (TwoArgumentCommand<?, ?>) command;
				if (!twoArgumentCommand.setArgument1(split[1])) {
					return new UnrecognizedCommand("First argument invalid ["
							+ split[1] + "]. Cannot interpret command [" + line
							+ "]");
				}
				if (!twoArgumentCommand.setArgument2(split[1])) {
					return new UnrecognizedCommand("Second argument invalid ["
							+ split[1] + "]. Cannot interpret command [" + line
							+ "]");
				}
				return command;
			}
		}

		return new UnrecognizedCommand("Cannot interpret command [" + line
				+ "]");

	}

	public BasicCommandInterpreter() {
		super();
		this.commands = new HashMap<String, CommandFactory>();
	}

}
