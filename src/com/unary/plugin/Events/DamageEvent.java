package com.unary.plugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener
{
	@EventHandler
    public void OnDamageEvent(EntityDamageEvent e)
    {
		if(e.getEntity() instanceof Player)
		{
			Location Locat = e.getEntity().getLocation();
			
			if(Locat.getWorld().equals(Bukkit.getWorlds().get(0)))
			{
				if(Locat.getBlockX() > 107 && Locat.getBlockX() < 365)
				{
					if(Locat.getBlockY() > 0 && Locat.getBlockY() < 257)
					{
						if(Locat.getBlockZ() > 19 && Locat.getBlockZ() < 277)
						{
							e.setCancelled(true);
						}
					}
				}
			}
		}
    }
}
