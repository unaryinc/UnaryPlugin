package com.unary.plugin.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Home implements CommandExecutor 
{
    JavaPlugin plugin;

    public Home(JavaPlugin plugin) 
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        String cmdName = cmd.getName().toLowerCase();

        if (cmdName.equals("home")) 
        {
            Player Send = (Player)sender;
            
            Location BedLocation = Send.getBedSpawnLocation();

            if(BedLocation == null)
            {
            	Send.sendMessage("У Вас нет кровати/дома к которым можно было бы телепортироваться");
            }
            else
            {
            	Send.sendMessage("Телепортируемся...");
            	Send.teleport(BedLocation);
            }
        }

        return true;
    }
}