package commands.impl;

import commands.Command;
import commands.Commands;

/**
 * Created by Nataly on 07.05.2015.
 */
public class PrintCommand extends Command {
    @Override
    public void execute() {
        System.out.println("Print command is not implemented yet.");
    }
    @Override
    public Commands getType() {
        return Commands.PRINT;
    }
}
