package com.josecode.blackjack.model;

import java.util.Map;

public class Message {
     private Language language;
     private Map<String, String> phrases;
     
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Map<String, String> getPhrases() {
		return phrases;
	}
	public void setPhrases(Map<String, String> phrases) {
		this.phrases = phrases;
	}
	
	public Message(Language language, Map<String, String> phrases) {
		super();
		this.language = language;
		this.phrases = phrases;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((phrases == null) ? 0 : phrases.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (phrases == null) {
			if (other.phrases != null)
				return false;
		} else if (!phrases.equals(other.phrases))
			return false;
		return true;
	}
}
