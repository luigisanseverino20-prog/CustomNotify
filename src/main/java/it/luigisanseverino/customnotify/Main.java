package it.luigisanseverino.customnotify;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Registra il listener degli eventi
        getServer().getPluginManager().registerEvents(
                new EventListener(this), this
        );

        // Registra il comando /cnreload
        getCommand("cnreload").setExecutor(new ReloadCommand(this));

        getLogger().info("CustomNotify avviato!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomNotify disattivato.");
    }
}