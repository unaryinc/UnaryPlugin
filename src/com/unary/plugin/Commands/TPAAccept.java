package com.unary.plugin.Commands;

import com.unary.plugin.*;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPAAccept implements CommandExecutor 
{
	Main Main;

    public TPAAccept(Main Main) 
    {
        this.Main = Main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
    	Player Send = (Player)sender;
    	
    	String Target = Main.PlayerManager.Get(Send).TeleportRequest;
    	
    	if(Target == null)
    	{
    		Send.sendMessage("На данный момент у Вас нет запросов на телепортацию.");
    	}
    	else
    	{
    		Player TargetPlayer = Bukkit.getPlayer(Target);
    		
    		if(TargetPlayer == null)
    		{
    			Send.sendMessage("Игрока запросившего телепорт нет на сервере.");
    		}
    		else
    		{
    			Main.PlayerManager.Get(Send).TeleportRequest = null;
    			
    			TargetPlayer.teleport(Send.getLocation());
    			
    			Send.sendMessage("Телепортируем...");
    			TargetPlayer.sendMessage("Телепортируем...");
    		}
    	}
    	
        return true;
    }
}