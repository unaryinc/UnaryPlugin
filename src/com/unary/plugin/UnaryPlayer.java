package com.unary.plugin;

import java.util.*;

public class UnaryPlayer
{
	public HashMap<String, Long> Cooldowns;
	public Boolean PlayedBefore;
	public String TeleportRequest;
	public String Permission;
	
	public UnaryPlayer()
	{
		Cooldowns = new HashMap<String, Long>();
		PlayedBefore = false;
		TeleportRequest = null;
		Permission = "unary.player";
	}
	
}
