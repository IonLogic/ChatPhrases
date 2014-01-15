package com.bugs3.zewildguy.chatphrases;

import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;


public class ChatPhrases extends JavaPlugin {

	@Override
	public void onDisable() {
		
		
	}
	
	@Override
	public void onEnable() {
		
		ChatPhrase.addPhrase("phrase_id", "phrase_content");
		ChatPhrase.addPhrase("example_phrase", "&3This is an example phrase!");
	}
}
