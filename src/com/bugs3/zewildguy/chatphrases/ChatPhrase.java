package com.bugs3.zewildguy.chatphrases;

import java.util.HashMap;
import java.util.Map;

//something
/**
 * ChatPhrase class stores all methods for ChatPhrase objects.
 * 
 * @author ZeWildGuy
 */
public class ChatPhrase {

	private static HashMap<String, String> LocalPhrases = new HashMap<String, String>();
	private static HashMap<String, String> GlobalPhrases = new HashMap<String, String>();
	
	public static String error = "The requested phrase could not be found!";
	
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
		
		String value = GlobalPhrases.get(phrase_id_key);
		
		return value;
	}
	
	private static String replaceVariables(String formatted_phrase, Map map_of_variables) {
		
		
		return formatted_phrase;
	}
	
	/**
	 * Gets a phrase specified by the plugin. You should be using getPhrase() as it performs a better search.
	 * 
	 * @author ZeWildGuy
	 * @param requested_phrase_id
	 * @return phrase
	 */
	public static String getLocalPhrase(String requested_phrase_id) {
		
		String phrase_key = match(requested_phrase_id);
		
		if(phrase_key != null) {
			String phrase_value = getValue(phrase_key);
	
			String final_phrase = ChatFormatParser.parseChatColour(phrase_value);
		
			return final_phrase;
		} else {
			return error;
		}
	}
	
	/**
	 * Looks for and retrieves a phrase specified in the config.yml file. If no phrase is found, it will search for a phrase specified by the plugin.
	 * Please refrain from using this method. It will be removed in a future update.
	 * 
	 * @author ZeWildGuy
	 * @param requested_phrase_id
	 * @param backup_phrase_id
	 * @return phrase
	 * @deprecated
	 */
	public static String getPhrase(String requested_phrase_id, String backup_phrase_id) {
		
		String phrase_key = matchGlobal(requested_phrase_id);
		String backup_phrase_key = match(backup_phrase_id);
		
		if(phrase_key != null) {
			String phrase_value = getValueGlobal(phrase_key);
			
			String final_phrase = ChatFormatParser.parseChatColour(phrase_value);
			return final_phrase;
			
		} else if(backup_phrase_key != null) {
			String phrase_key1 = match(backup_phrase_id);
			
			String phrase_value1 = getValue(phrase_key1);
		
			String final_phrase1 = ChatFormatParser.parseChatColour(phrase_value1);
			return final_phrase1;
			
		} else {
			return error;
		}
		
		
	}
	
	/**
	 * Looks for and retrieves a phrase specified in the config.yml file. If no phrase is found, it will search for a phrase specified by the plugin.
	 * Also replaces variables with the values specified in the array.
	 * 
	 * @author ZeWildGuy
	 * @param requested_phrase_id The phrase that is requested.
	 * @param backup_phrase_id The backup phrase that is requested.
	 * @param array An array of variables and their values. 
	 * @return phrase
	 */
	public static String getPhrase(String requested_phrase_id, String backup_phrase_id, Map map_of_variabes) {
		
		String phrase_key = matchGlobal(requested_phrase_id);
		String backup_phrase_key = match(backup_phrase_id);
		
		if(phrase_key != null) {
			String phrase_value = getValueGlobal(phrase_key);
			String final_phrase_value = replaceVariables(phrase_value, map_of_variabes); //replaces variable names with content
			
			String final_phrase = ChatFormatParser.parseChatColour(final_phrase_value);
			return final_phrase;
			
		} else if(backup_phrase_key != null) {
			String phrase_key1 = match(backup_phrase_id);
			
			String phrase_value1 = getValue(phrase_key1);
		
			String formatted_phrase1 = ChatFormatParser.parseChatColour(phrase_value1);
			String final_phrase1 = replaceVariables(formatted_phrase1, array_of_variabes); //replaces variable names with content
			return final_phrase1;
			
		} else {
			return error;
		}
	}

	/**
	 * Adds a phrase to the GlobalPhrase list. <b>Not for general use.</b>
	 * @author ZeWildGuy
	 * @param phrase_id
	 * @param phrase
	 */
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
