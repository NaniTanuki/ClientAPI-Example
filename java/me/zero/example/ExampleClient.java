package me.zero.example;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import me.zero.client.api.Client;
import me.zero.client.api.ClientAPI;
import me.zero.client.api.ClientInfo;
import me.zero.client.api.event.defaults.TextEvent;
import me.zero.client.api.event.handle.ClientHandler;
import me.zero.example.command.CommandManager;
import me.zero.example.mod.ExampleModManager;

/**
 * Created by Brady on 1/19/2017.
 */
public final class ExampleClient extends Client {

    private static ExampleClient instance;
    private ClientInfo info;

    public ExampleClient() {
        instance = this;
    }

    @Override
    public void onInit(ClientHandler handler) {
        /*
        AuthenticationFactory.create().username("example@host.xyz").password("12345").login(); // Login to our account
        */

        this.info = getInfo();                           // Gets the client info for later usage
        this.setModuleManager(new ExampleModManager());  // Create Module Manager
        this.getModuleManager();                         // Gets the module manager as a generic Manager<Module>
//        <ExampleModManager>this.getModuleManager();      // Gets the Module Manager casted to our implementation
        this.loadPlugins("path/to/plugins");             // Load plugins
        this.getModuleManager().load();                  // Load mods

        this.setCommandManager(new CommandManager());    // Create Command Manager
        this.getCommandManager().load();                 // Load Commands

        // Simple Protocol Hack (Used for connecting to b0at.xyz for testing)
        ProtocolPatcher patcher = new ProtocolPatcher();
        patcher.setProtocol(315);

        ClientAPI.EVENT_BUS.subscribe(new Object() {
            @EventHandler
            private final Listener<TextEvent> textEventListener = new Listener<>(event -> {
                if (event.getText().contains("Singleplayer")) {
                    event.setText(event.getText().replace("Singleplayer", "SingleplayerXDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"));
                }
            });
        });
    }

    public String getName() {
        return this.info.getName();
    }

    public double getVersion() {
        return this.info.getBuild();
    }

    public static ExampleClient getInstance() {
        return instance;
    }
}
