package me.zero.example.command;

import me.zero.client.api.ClientAPI;
import me.zero.client.api.command.Command;
import me.zero.client.api.command.handler.CommandHandler;
import me.zero.client.api.command.handler.listener.ChatCommandListener;
import me.zero.client.api.manage.Manager;
import me.zero.example.ExampleClient;
import me.zero.example.command.commands.TestCommand;

/**
 * Created by Brady on 2/16/2017.
 */
public final class CommandManager extends Manager<Command> {

    private final CommandHandler handler = new CommandHandler(ExampleClient.getInstance());

    public CommandManager() {
        super("Command");
    }

    @Override
    public void load() {
        this.addData(
                new TestCommand()
        );

        // Setup the handler and a chat command listener
        ClientAPI.EVENT_BUS.subscribe(
                handler,
                new ChatCommandListener(handler)
        );
    }

    @Override
    public void save() {}
}
