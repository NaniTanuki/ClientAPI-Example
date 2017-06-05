package me.zero.example.command.commands;

import me.zero.client.api.command.Cmd;
import me.zero.client.api.command.Command;
import me.zero.client.api.command.exception.CommandException;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.text.TextComponentString;

/**
 * @author Brady
 * @since 5/31/2017 6:18 PM
 */
@Cmd(headers = { "test", "me/zero/example"}, description = "Test Command")
public final class TestCommand extends Command {

    @Override
    public void execute(NetworkPlayerInfo sender, String[] arguments) throws CommandException {
        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(
                String.format("%s executed the \"Test\" command!", sender.getGameProfile().getName())
        ));
    }
}
