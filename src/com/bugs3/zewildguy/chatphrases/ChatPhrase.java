package com.bugs3.zewildguy.chatphrases;

import java.util.HashMap;

public class ChatPhrase {

	private static HashMap<String, String> LocalPhrases = new HashMap<String, String>();
	private static HashMap<String, String> GlobalPhrases = new HashMap<String, String>();
	
	public static String match(String phrase_to_match) {
		boolean match = false; 
		String error = "The requested phrase could not be found!";
		
		for(String phrase_key : LocalPhrases.keySet()) {
			if(phrase_key.equalsIgnoreCase(phrase_to_match)) {
                        
                        match = true;
                        return phrase_key;
            } 
        }
		
		if(!match) {
			return error;
		}
		return error;
	}
	
	public static String matchGlobal(String phrase_to_match) {
		boolean match = false; 
		//String error = "The requested phrase could not be found!";
		
		for(String phrase_key : GlobalPhrases.keySet()) {
			if(phrase_key.equalsIgnoreCase(phrase_to_match)) {
                        
                        match = true;
                        return phrase_key;
            }
        }
		
		if(!match) {
			return null;
		}
		return null;
	}
	
	public static String getValue(String phrase_id_key) {
		
		String value = LocalPhrases.get(phrase_id_key);
		
		return value;
	}
	
	public static String getValueGlobal(String phrase_id_key) {
		
		String value = LocalPhrases.get(phrase_id_key);
		
		return value;
	}
	
	/**
	 * Gets a phrase specified by the plugin.
	 * 
	 * @author ZeWildGuy
	 * @param requested_phrase_id
	 * @return phrase
	 */
	public static String getLocalPhrase(String requested_phrase_id) {
		
		String phrase_key = match(requested_phrase_id);
		
		String phrase_value = getValue(phrase_key);
	
		String final_phrase = ChatFormatParser.parseChatColour(phrase_value);
		
		return final_phrase;
	}
	
	/**
	 * Looks for and gets a phrase specified in the config.yml file. If no phrase is found, it will search for a phrase specified by the plugin.
	 * 
	 * @author mba2012
	 * @param requested_phrase_id
	 * @return phrase
	 */
	public static String getPhrase(String requested_phrase_id) {
		
		String phrase_key = matchGlobal(requested_phrase_id);
		
		if(phrase_key != null) {
			String phrase_value = getValueGlobal(phrase_key);
			
			String final_phrase = ChatFormatParser.parseChatColour(phrase_value);
			
			return final_phrase;
		} else {
			String phrase_key1 = match(requested_phrase_id);
			
			String phrase_value1 = getValue(phrase_key1);
		
			String final_phrase1 = ChatFormatParser.parseChatColour(phrase_value1);
			return final_phrase1;
		}
		
		
	}
	
	public static void addGlobalPhrase(String phrase_id, String phrase) {
        GlobalPhrases.put(phrase_id, phrase);
	}
	
	/**
	 * Adds a phrase to the phrase list.
	 * 
	 * @author ZeWildGuy
	 * @param phrase_id
	 * @param phrase
	 */
	public static void addPhrase(String phrase_id, String phrase) {
        LocalPhrases.put(phrase_id, phrase);
	}
}
