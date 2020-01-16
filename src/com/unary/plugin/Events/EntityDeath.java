package com.unary.plugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener
{
	@EventHandler
    public void OnEntityDeath(EntityDeathEvent e)
    {
		if(e.getEntity() instanceof Monster)
		{
			Location Locat = e.getEntity().getLocation();
			
			if(Locat.getWorld().equals(Bukkit.getWorlds().get(0)))
			{
				if(Locat.getBlockX() > 104 && Locat.getBlockX() < 368)
				{
					if(Locat.getBlockY() > -3 && Locat.getBlockY() < 260)
					{
						if(Locat.getBlockZ() > 22 && Locat.getBlockZ() < 280)
						{
							e.setDroppedExp(0);
							e.getDrops().clear();
						}
					}
				}
			}
		}
    }
}
