package me.zero.example.mod.mods;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import me.zero.client.api.event.defaults.UpdateEvent;
import me.zero.client.api.module.Mod;
import me.zero.client.api.module.Module;
import me.zero.example.mod.category.IMovement;
import org.lwjgl.input.Keyboard;

/**
 * Created by Brady on 2/8/2017.
 */
@Mod(name = "Fly", description = "Allows you to fly", bind = Keyboard.KEY_F)
public final class Fly extends Module implements IMovement {

    @EventHandler
    private Listener<UpdateEvent> updateListener = new Listener<>(event ->
        mc.player.motionY = Boolean.valueOf(mc.gameSettings.keyBindJump.isKeyDown()).compareTo(mc.gameSettings.keyBindSneak.isKeyDown()) * 0.2
    );
}
