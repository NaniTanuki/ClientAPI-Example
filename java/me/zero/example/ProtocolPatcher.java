package me.zero.example;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import me.zero.client.api.ClientAPI;
import me.zero.client.api.event.defaults.PacketEvent;
import me.zero.client.api.event.defaults.filters.PacketFilter;
import me.zero.client.api.util.ReflectionUtils;
import net.minecraft.network.handshake.client.C00Handshake;

/**
 * Created by Brady on 2/16/2017.
 */
public final class ProtocolPatcher {

    private int protocol = 316;

    public ProtocolPatcher() {
        ClientAPI.EVENT_BUS.subscribe(this);
    }

    @EventHandler
    private Listener<PacketEvent.Send> packetSendListener = new Listener<>(event -> {
        C00Handshake handshake = (C00Handshake) event.getPacket();
        // This obviously won't work in an obfuscated environment
        ReflectionUtils.setField(handshake, "protocolVersion", protocol);
    }, new PacketFilter<>(C00Handshake.class));

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }
}
