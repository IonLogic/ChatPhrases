package com.bugs3.zewildguy.chatphrases;

import java.util.Arrays;
import java.util.List;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class ChatPhrases extends JavaPlugin {

	public Plugin plugin = this.plugin;
	public Plugin plugina = plugin;
	
	@Override
	public void onDisable() {
		
		
	}
	
	@Override
	public void onEnable() {
		
		this.saveDefaultConfig();
		
		List<String> listOfStrings = this.getConfig().getStringList("phrases");
		
		ChatPhrase.addPhrase("phrase_id", "phrase_content");
		
		for(String phrase : listOfStrings) {
			//String[] splits = phrase.split("%b", 2);
			String[] temp;
			temp = phrase.split("%b%", 2);
			
			String phrase_id = temp[0];
			String phrase_content = temp[1];
			
			ChatPhrase.addGlobalPhrase(phrase_id, phrase_content);

		}
	}
	
	public static String errorHandler(String phrase_id) {
		String error = "The requested phrase could not be found!";
		 if(plugin.getConfig().getString("settings.phrase-fallback") != null) {
			 if(plugin.getConfig().getString("settings.phrase-fallback") == "false") {
				 error = plugin.getConfig().getString("settings.error-message");
				 return error;
			 }
			 return error;
		 } else {
			 error = phrase_id;
			 return error;
		 }
	}
}
