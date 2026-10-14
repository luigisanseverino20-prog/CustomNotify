package it.luigisanseverino.customnotify;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
// Classe che gestisce il comando /cnreload
public class ReloadCommand implements CommandExecutor {
//Riferimento al plugin principale
    private final Main plugin;
// Costruttore - Riceve il plugin per accedere alle sue funzioni
    public ReloadCommand(Main plugin) {
        this.plugin = plugin;
    }
//Metodo chiamato quando qualcuno esegue /cnreload
    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {
//Ricarica il file config.yml senza riavviare il server
        plugin.reloadConfig();
// Questo testo rimanda un messaggio al gioco che la configurazione è avviata con successo.
        sender.sendMessage(ChatColor.GREEN +
                "[CustomNotify] Config ricaricata con successo!");
//Dice a minecraft che il comando è stato eseguito correttamente
        return true;
    }
}

