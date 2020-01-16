package com.unary.plugin.Events;
import com.unary.plugin.*;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener
{
	Main Main;
	
	public PlayerQuit(Main Main)
	{
		this.Main = Main;
	}
	
	@EventHandler
    public void OnPlayerQuit(PlayerQuitEvent e)
    {
		e.setQuitMessage(ChatColor.YELLOW + e.getPlayer().getName() + " выходит с сервера");
    }
}