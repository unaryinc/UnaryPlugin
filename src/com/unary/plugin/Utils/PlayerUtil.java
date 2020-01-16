package com.unary.plugin.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class PlayerUtil 
{
	public static List<Player> GetPlayersNearby(Player Target, int Radius)
	{
		List<Player> Result = new ArrayList<Player>();
		
		for(Entity CurrentEntity : Target.getNearbyEntities(Radius, Radius, Radius))
    	{
    		if(CurrentEntity.getType() == EntityType.PLAYER)
    		{
    			Result.add((Player)CurrentEntity);
    		}
    	}
		
		return Result;
	}
}
