package com.josecode.blackjack.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import com.josecode.blackjack.model.Pair;

public final class Configuration {
    
	private final List<Pair> valuesCards;
	private final List<Pair> languages;
	
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
			  	  .map(s -> Pair.of(s[0], Integer.valueOf(s[1])))  
				  .collect(Collectors.toList());  
	}

	public List<Pair> getValues() {
		return Collections.unmodifiableList(valuesCards);
	}

	public List<Pair> getLanguages() {
		return Collections.unmodifiableList(languages);
	}
}
