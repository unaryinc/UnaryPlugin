package com.unary.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Test implements CommandExecutor 
{
    JavaPlugin plugin;

    public Test(JavaPlugin plugin) 
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        String cmdName = cmd.getName().toLowerCase();

        if (cmdName.equals("test")) 
        {
        	sender.sendMessage("No");
        }

        return true;
    }
}