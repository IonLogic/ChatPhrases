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
		
		List<String> listOfStrings = Arrays.asList("Hello World", "Welcome to Bukkit", "Have a Good Day!");
		this.getConfig().set("phrases", listOfStrings);
		
		ChatPhrase.addPhrase("phrase_id", "phrase_content");
		ChatPhrase.addPhrase("example_phrase", "&3This is an example phrase!");
		
		for(String phrase : listOfStrings) {
			phrase.split("");
			
			String phrase_id = null;
			String phrase_content = null;
			
			ChatPhrase.addGlobalPhrase(phrase_id, phrase_content);
		}
		
		
	}
}
