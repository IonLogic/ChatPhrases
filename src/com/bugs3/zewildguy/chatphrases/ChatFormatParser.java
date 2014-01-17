package com.bugs3.zewildguy.chatphrases;

import org.bukkit.ChatColor;

public class ChatFormatParser {

	public static String parseChatColour(String message) {
		
		//Parse Colours
		message = message.replaceAll("&0", ChatColor.BLACK + "");
		message = message.replaceAll("&1", ChatColor.DARK_BLUE + "");
		message = message.replaceAll("&2", ChatColor.DARK_GREEN + "");
		message = message.replaceAll("&3", ChatColor.DARK_AQUA + "");
		message = message.replaceAll("&4", ChatColor.DARK_RED + "");
		message = message.replaceAll("&5", ChatColor.DARK_PURPLE + "");
		message = message.replaceAll("&6", ChatColor.GOLD + "");
		message = message.replaceAll("&7", ChatColor.GRAY + "");
		message = message.replaceAll("&8", ChatColor.DARK_GRAY + "");
		message = message.replaceAll("&9", ChatColor.BLUE + "");
		message = message.replaceAll("&a", ChatColor.GREEN + "");
		message = message.replaceAll("&b", ChatColor.AQUA + "");
		message = message.replaceAll("&c", ChatColor.RED + "");
		message = message.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
		message = message.replaceAll("&e", ChatColor.YELLOW + "");
		message = message.replaceAll("&f", ChatColor.WHITE + "");
		
		return message;
	}
	
	public static String parseChatFormat(String message) {
		
		//Parse Colours
		message = message.replaceAll("&k", ChatColor.MAGIC + "");
		message = message.replaceAll("&0", ChatColor.ITALIC + "");
		message = message.replaceAll("&n", ChatColor.UNDERLINE + "");
		message = message.replaceAll("&m", ChatColor.STRIKETHROUGH + "");
		message = message.replaceAll("&l", ChatColor.BOLD + "");
		message = message.replaceAll("&r", ChatColor.RESET + "");
		
		return message;
	}

	public static String parseChat(String message) {
	
	message = parseChatColour(message);
	message = parseChatFormat(message);	
	
	return message;
	}
}