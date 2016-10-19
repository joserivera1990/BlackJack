package com.josecode.blackjack.model;

import java.util.Map;
import java.util.Objects;

public final class Message {
	
     private final Language language;
     private final Map<String, String> phrases;
     
	public Language getLanguage() {
		return language;
	}
	
	public Map<String, String> getPhrases() {
		return phrases;
	}
		
	public Message(final Language language, final Map<String, String> phrases) {
		super();
		this.language = language;
		this.phrases = phrases;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(language,phrases);
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
