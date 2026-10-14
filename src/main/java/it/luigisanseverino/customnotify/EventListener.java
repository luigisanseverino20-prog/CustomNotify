package it.luigisanseverino.customnotify;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EventListener implements Listener {

    private final Main plugin;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public EventListener(Main plugin) {
        this.plugin = plugin;
    }

    private String getTime() {
        return LocalTime.now().format(formatter);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!plugin.getConfig().getBoolean("settings.join-enabled")) return;

        String msg = plugin.getConfig().getString("messages.join");
        msg = msg.replace("{player}", event.getPlayer().getName());
        msg = msg.replace("{time}", getTime());
        msg = ChatColor.translateAlternateColorCodes('&', msg);

        event.setJoinMessage(msg);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (!plugin.getConfig().getBoolean("settings.quit-enabled")) return;

        String msg = plugin.getConfig().getString("messages.quit");
        msg = msg.replace("{player}", event.getPlayer().getName());
        msg = msg.replace("{time}", getTime());
        msg = ChatColor.translateAlternateColorCodes('&', msg);

        event.setQuitMessage(msg);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (!plugin.getConfig().getBoolean("settings.death-enabled")) return;

        String msg = plugin.getConfig().getString("messages.death");
        msg = msg.replace("{player}", event.getEntity().getName());
        msg = msg.replace("{time}", getTime());
        msg = ChatColor.translateAlternateColorCodes('&', msg);

        event.setDeathMessage(msg);
    }
}