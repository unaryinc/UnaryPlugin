package com.unary.plugin.Commands;

import com.unary.plugin.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPA implements CommandExecutor 
{
	Main Main;

    public TPA(Main Main) 
    {
        this.Main = Main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
    	Player Send = (Player)sender;
    	
    	if(args.length != 1)
    	{
    		Send.sendMessage("Неверное количество аргументов.");
    	}
    	else
    	{
    		Player Target = Bukkit.getPlayer(args[0]);
    		
    		if(Target == null)
    		{
    			Send.sendMessage("Данного игрок сейчас нет на сервере.");
    		}
    		else
    		{
    			if(Target.isOnline())
        		{
    				if(Send.equals(Target))
    				{
    					Send.sendMessage("Вы не можете телепортироваться на самого/саму себя.");
    				}
    				else
    				{
    					Main.PlayerManager.Get(Target).TeleportRequest = Send.getName();
    					
    					Target.sendMessage(ChatColor.BLUE + Send.getName() + ChatColor.AQUA + " желает телепортироваться к Вам");
    					Target.sendMessage(ChatColor.GOLD + "/tpaaccept" + ChatColor.GREEN + " чтобы принять запрос");
    					Target.sendMessage(ChatColor.GOLD + "/tpadeny" + ChatColor.RED + " чтобы отменить запрос");
    					
    					Send.sendMessage("Ваша заявка была отправлена.");
    				}
        		}
        		else
        		{
        			Send.sendMessage("Данного игрок сейчас нет на сервере.");
        		}
    		}
    	}
    	
        return true;
    }
}