package com.josecode.blackjack.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.stream.Collectors;

import com.josecode.blackjack.model.Language;
import com.josecode.blackjack.model.Pair;

public final class Configuration {
    
	private final List<Pair> valuesCards;
	private final List<Language> languages;
	private  Map<String,Map<String, String>> mapMessages;
	
	
	public Configuration() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties p = new Properties();
		p.load(inputStream);
		valuesCards = Arrays.stream(p.getProperty("value.characters").split(":"))
				    .map(r -> r.split(","))  
				  	.map(s -> Pair.of(s[0], Integer.valueOf(s[1])))
				  	.collect(Collectors.toList());
		languages = Arrays.stream(p.getProperty("languages").split(":"))
			      .map(r -> r.split(","))  
			  	  .map(s -> Language.of(s[0], s[1]))  
				  .collect(Collectors.toList());
		buildListMessages();
	}

	private void buildListMessages() throws IOException {
		mapMessages = new HashMap<>();
		for (Language language : languages) {
			Map<String, String> phrases = new HashMap<>();
			String nameFile = "language_"+ language.getCode() + ".properties";
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
			Properties p = new Properties();
			p.load(inputStream);
			for (Entry<Object, Object> entry : p.entrySet()) {
			    phrases.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
			}
			mapMessages.put(language.getCode(),phrases);
		}
	}
	
	public List<Pair> getValues() {
		return Collections.unmodifiableList(valuesCards);
	}

	public List<Language> getLanguages() {
		return Collections.unmodifiableList(languages);
	}

	public Map<String,Map<String, String>> getMapMessages() {
		return Collections.unmodifiableMap(mapMessages);
	}
}
