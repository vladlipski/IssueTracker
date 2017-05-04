package by.issue_tracker.command.factory;

import by.issue_tracker.command.Command;
import by.issue_tracker.command.CommandName;
import by.issue_tracker.command.impl.SignInCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {

    private static final CommandRepository instance = new CommandRepository();

    private Map<CommandName, Command> repository;

    private CommandRepository() {
        repository = new HashMap<CommandName, Command>();

        repository.put(CommandName.SIGN_IN, new SignInCommand());
    }

    public static CommandRepository getInstance() {
        return instance;
    }

    public Command getCommand(String requestedCommand) {
        CommandName commandName;
        Command command;

        commandName = CommandName.valueOf(requestedCommand.toUpperCase());
        if (repository.containsKey(commandName)) {
            command = repository.get(commandName);
        } else {
            return null;
        }

        return command;
    }
}
