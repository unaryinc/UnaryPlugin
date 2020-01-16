package com.unary.plugin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UnaryPlayerManager 
{
	private JavaPlugin Plugin;
	
	private String FilePath;
	
	private HashMap<String, UnaryPlayer> Players;
	
	public UnaryPlayerManager(JavaPlugin Plugin)
	{
		this.Plugin = Plugin;
	}
	
	public UnaryPlayer Get(Player Player)
	{
		return Get(Player.getName());
	}
	
	public UnaryPlayer Get(String Player)
	{
		if(!Players.containsKey(Player))
		{
			Players.put(Player, new UnaryPlayer());
		}
		
		return Players.get(Player);
	}

	public void Load()
	{
		
		FilePath = Plugin.getDataFolder().getAbsolutePath() + '/' + "Players.json";
		
		File PluginFolder = new File(Plugin.getDataFolder().getAbsolutePath());
	    if (!PluginFolder.exists())
	    {
	    	PluginFolder.mkdir();
	    }
		
	    File PlayerFile = new File(FilePath);
	    
	    if(PlayerFile.exists())
	    {
	    	
	    	String ReadStuff = "";
	    	
	    	try
	    	{
	    		ObjectMapper mapper = new ObjectMapper();
	    		
	    		ReadStuff = new String(Files.readAllBytes(Paths.get(FilePath)));
	    		
	    		Players = mapper.readValue(ReadStuff, new TypeReference<HashMap<String,UnaryPlayer>>(){});
	    		
	    		for(Player p : Bukkit.getOnlinePlayers())
	    		{
	    			p.sendMessage("Loaded successfully.");
	    		}
	    	}
	    	catch(JsonProcessingException Exception)
	    	{
	    		for(Player p : Bukkit.getOnlinePlayers())
	    		{
	    			p.sendMessage(Exception.getMessage());
	    		}
	    		
	    		Players = new HashMap<String, UnaryPlayer>();
	    	}
	    	catch(Exception Exception)
	    	{
	    		for(Player p : Bukkit.getOnlinePlayers())
	    		{
	    			p.sendMessage("Failed to read from file");
	    			p.sendMessage(ReadStuff);
	    		}
	    		
	    		Players = new HashMap<String, UnaryPlayer>();
	    	}
	    }
	    else
	    {
	    	for(Player p : Bukkit.getOnlinePlayers())
    		{
    			p.sendMessage("Failed to find file");
    		}
	    	
	    	Players = new HashMap<String, UnaryPlayer>();
	    }		
	}
	
	public void Save()
	{
		File PlayerFile = new File(FilePath);
		
		if(PlayerFile.exists())
		{
			PlayerFile.delete();
		}

		try
		{
			PlayerFile.createNewFile();
			
			ObjectMapper mapper = new ObjectMapper();
    		
			mapper.enable(SerializationFeature.INDENT_OUTPUT);			
			
    		mapper.writeValue(PlayerFile, Players);
		}
		catch(Exception Exception)
    	{
			for(Player p : Bukkit.getOnlinePlayers())
    		{
    			p.sendMessage("Failed to save file");
    		}
    	}
	}
}
