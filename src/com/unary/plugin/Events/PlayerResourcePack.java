package com.unary.plugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status;
import org.bukkit.plugin.java.JavaPlugin;
public class PlayerResourcePack implements Listener
{
	JavaPlugin plugin;
	
	public PlayerResourcePack(JavaPlugin plugin) 
    {
        this.plugin = plugin;
    }
	
	@EventHandler
    public void OnPlayerResourcePack(PlayerResourcePackStatusEvent e)
    {
		if(e.getStatus() == Status.DECLINED)
		{
			Bukkit.getScheduler().runTask(plugin, new Runnable() 
			{
				  public void run() 
				  {
					  e.getPlayer().kickPlayer("Для того чтобы играть на ланнном сервере Вам необходимо принять загрузку ресурс-пака.");
				  }
			});
		}
		
		if(e.getStatus() == Status.FAILED_DOWNLOAD)
		{
			Bukkit.getScheduler().runTask(plugin, new Runnable() 
			{
				  public void run() 
				  {
					  e.getPlayer().kickPlayer("К сожалению загрузка ресурс-пака обосралась.");
				  }
			});
		}

    }
}
