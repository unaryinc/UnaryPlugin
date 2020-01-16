package com.unary.plugin.Events;
import com.unary.plugin.*;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoined implements Listener
{
	Main Main;
	
	public PlayerJoined(Main Main)
	{
		this.Main = Main;
	}
	
	@EventHandler
    public void OnPlayerJoined(PlayerJoinEvent e)
    {
		Player Player = e.getPlayer();
		UnaryPlayer UnaryPlayer = Main.PlayerManager.Get(Player);
		
		if(UnaryPlayer.PlayedBefore == false)
		{
			e.setJoinMessage(ChatColor.DARK_AQUA + Player.getName() + " впервые заходит на сервер");
			UnaryPlayer.PlayedBefore = true;
		}
		else
		{
			e.setJoinMessage(ChatColor.YELLOW + Player.getName() + " заходит на сервер");
		}
		
		Player.sendMessage(ChatColor.GOLD + "Добро пожаловать на сервер Unary Vanilla!");
		Player.sendMessage(ChatColor.AQUA + "Сервер был создан 08/01/2020, и над ним всё ещё ведётся активная разработка.");
		Player.sendMessage(ChatColor.AQUA + "Сервер перезапускается каждый день ровно в 0:00 по московскому времени.");
		Player.sendMessage(ChatColor.YELLOW + "/help" + ChatColor.GREEN + " - для того чтобы посмотреть список команд.");
		Player.sendMessage(ChatColor.RED + "Приятной игры!");
    }
}