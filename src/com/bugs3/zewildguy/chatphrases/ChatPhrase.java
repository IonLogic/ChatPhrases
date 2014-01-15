package com.bugs3.zewildguy.chatphrases;

import java.util.HashMap;

public class ChatPhrase {

	private static HashMap<String, String> phrases = new HashMap<String, String>();
	
	public static String match(String phrase_to_match) {
		boolean match = false; 
		String error = "The requested phrase could not be found!";
		
		for(String phrase_key : phrases.keySet()) {
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
	
	public static String getValue(String phrase_id_key) {
		
		String value = phrases.get(phrase_id_key);
		
		return value;
	}
	
	public static String getPhrase(String requested_phrase_id) {
		
		String phrase_key = match(requested_phrase_id);
		
		String phrase_value = getValue(phrase_key);
	
		String final_phrase = ChatFormatParser.parseChatColour(phrase_value);
		
		return final_phrase;
	}
	
	public static void addPhrase(String phrase_id, String phrase) {
        phrases.put(phrase_id, phrase);
	}
}
