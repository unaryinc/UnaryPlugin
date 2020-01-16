package com.unary.plugin.Events;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerMessage implements Listener
{
	JavaPlugin plugin;
	
	public PlayerMessage(JavaPlugin plugin) 
    {
        this.plugin = plugin;
    }
	
	@EventHandler(priority = EventPriority.HIGH)
    public void OnPlayerMessage(AsyncPlayerChatEvent e)
    {
		if(e.getMessage().contains("meme"))
		{
			Bukkit.getScheduler().runTask(plugin, new Runnable() 
			{
				  public void run() 
				  {
					  e.getPlayer().kickPlayer("Что это такое ты написал?");
				  }
			});
		}
    }
}
