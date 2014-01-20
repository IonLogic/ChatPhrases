package com.bugs3.zewildguy.chatphrases;

import java.util.Arrays;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;


public class ChatPhrases extends JavaPlugin {

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
			temp = phrase.split("%b", 2);
			
			String phrase_id = temp[0];
			String phrase_content = temp[1];
			
			ChatPhrase.addGlobalPhrase(phrase_id, phrase_content);

		}
	}
}
