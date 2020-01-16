package com.unary.plugin.Events;

//import java.util.HashMap;
//import java.util.List;

//import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;


public class PlayerSneaking implements Listener
{
	//private HashMap<Player, List<Player>> NearbyPlayers;
	
	public PlayerSneaking()
	{
		//NearbyPlayers = new HashMap<Player, List<Player>>();
	}
	
	@EventHandler
    public void OnPlayerSneaking(PlayerToggleSneakEvent e)
    {
		//Player Target = e.getPlayer();
		
		/*
        if (e.isSneaking()) 
        {
        	List<Player> NearPlayers = new ArrayList<Player>();
        	
        	NearPlayers.add(Target);
        	NearPlayers.addAll(PlayerUtil.GetPlayersNearby(Target, 32));
        	NearbyPlayers.put(Target, NearPlayers);
        	
        	for(Player CurrentPlayer : NearbyPlayers.get(Target))
        	{
        		CurrentPlayer.playSound(Target.getLocation(), "minecraft:unary.sneak", 100, 1);
        	}
        }
        else
        {
        	for(Player CurrentPlayer : NearbyPlayers.get(Target))
        	{
        		CurrentPlayer.stopSound("minecraft:unary.sneak");
        	}
        	
        	NearbyPlayers.remove(Target);
        }
       */
    }
}
