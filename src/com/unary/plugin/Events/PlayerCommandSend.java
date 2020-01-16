package com.unary.plugin.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;;

public class PlayerCommandSend implements Listener
{
	@EventHandler
    public void OnPlayerCommandSend(PlayerCommandPreprocessEvent e)
    {
		if(e.getMessage().startsWith("/help"))
		{
			e.setMessage("/help UnaryPlugin");
		}
    }
}
