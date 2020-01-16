package com.unary.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GetPlayer implements CommandExecutor 
{
    JavaPlugin plugin;

    public GetPlayer(JavaPlugin plugin) 
    {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        String cmdName = cmd.getName().toLowerCase();

        if (cmdName.equals("spawn")) 
        {
            Player Send = (Player)sender;
            Send.teleport(new Location(Bukkit.getWorlds().get(0), 236, 63, 148));
            Send.sendMessage("Телепортируемся...");
        }

        return true;
    }
}