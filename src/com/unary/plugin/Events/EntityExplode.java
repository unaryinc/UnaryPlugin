package com.unary.plugin.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplode implements Listener
{
	@EventHandler
    public void OnEntityExplode(EntityExplodeEvent e)
    {
		e.blockList().clear();
    }
}
