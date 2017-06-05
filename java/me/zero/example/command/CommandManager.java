package me.zero.example.command;

import me.zero.client.api.command.Command;
import me.zero.client.api.manage.Manager;
import me.zero.example.command.commands.TestCommand;

/**
 * Created by Brady on 2/16/2017.
 */
public final class CommandManager extends Manager<Command> {

    public CommandManager() {
        super("Command");
    }

    @Override
    public void load() {
        this.addData(new TestCommand());
    }

    @Override
    public void save() {}
}
