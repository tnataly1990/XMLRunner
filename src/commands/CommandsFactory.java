package commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nataly on 07.05.2015.
 */
public class CommandsFactory {
    private static CommandsFactory commandsFactory;
    private List<Command> commands = new ArrayList<>();

    private CommandsFactory() {
    }

    public static CommandsFactory getInstance() {
        if (commandsFactory == null) {
            commandsFactory = new CommandsFactory();
        }
        return commandsFactory;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void runCommand(String command) {
        for (Command cmd : commands) {
            if (cmd.getType().getNameInXml().equalsIgnoreCase(command)) {
                cmd.execute();
                return;
            }
        }
        System.out.println("Command " + command + " not found in commands xml or it is disabled.");
    }
}
