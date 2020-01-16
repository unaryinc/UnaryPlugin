package com.unary.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;

import com.unary.plugin.Commands.*;
import com.unary.plugin.Events.*;

public class Main extends JavaPlugin 
{
	public UnaryPlayerManager PlayerManager;
	
    @Override
    public void onDisable() 
    {
    	PlayerManager.Save();
    }

    @Override
    public void onEnable()
    {
    	PlayerManager = new UnaryPlayerManager(this);
    	PlayerManager.Load();
    	
        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("sethome").setExecutor(new SetHome(this));
        getCommand("home").setExecutor(new Home(this));
        getCommand("test").setExecutor(new Test(this));
        getCommand("tpa").setExecutor(new TPA(this));
        getCommand("tpaaccept").setExecutor(new TPAAccept(this));
        getCommand("tpadeny").setExecutor(new TPADeny(this));
        
        getServer().getPluginManager().registerEvents(new EntityDeath(), this);
        getServer().getPluginManager().registerEvents(new EntityExplode(), this);
        
        getServer().getPluginManager().registerEvents(new CreatureSpawn(), this);
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        
        getServer().getPluginManager().registerEvents(new PlayerJoined(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(this), this);
        getServer().getPluginManager().registerEvents(new PlayerMessage(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerSneaking(), this);
        getServer().getPluginManager().registerEvents(new PlayerResourcePack(this), this);
        getServer().getPluginManager().registerEvents(new PlayerCommandSend(), this);
        
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() 
		{
			  public void run()
			  {
				  BoundingBox Area = new BoundingBox(108, 0, 20, 364, 256, 276);
					
				  for(Entity e : Bukkit.getWorlds().get(0).getNearbyEntities(Area))
				  {
					  if(e instanceof Monster)
					  {
						  Monster Monster = (Monster)e;
						  Monster.setHealth(0);
					  }
				  }
				  
				  /*
				  for(Player test : Bukkit.getOnlinePlayers())
				  {
					  Location Main = test.getLocation();
					  
					  Vector New = new Vector(Main.getBlockX(), Main.getBlockY(), Main.getBlockZ());
					  
					  if(!Area.contains(New))
					  {
						  test.setHealth(0);
					  }
				  }
				  */
			  }
		}, 0, 20);
    }
}