package com.unary.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetHome implements CommandExecutor 
{
    JavaPlugin plugin;

    public SetHome(JavaPlugin plugin) 
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        String cmdName = cmd.getName().toLowerCase();

        if (cmdName.equals("sethome")) 
        {
            Player Send = (Player)sender;
            
            Send.setBedSpawnLocation(Send.getLocation(), true); 
            
            Send.sendMessage("Дом установлен.");
        }

        return true;
    }
}