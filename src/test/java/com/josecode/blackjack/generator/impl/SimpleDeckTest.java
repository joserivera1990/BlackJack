package com.josecode.blackjack.generator.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.model.Pair;

public class SimpleDeckTest {
   	
	private List<Pair> listValues = new ArrayList<>();
	
	@Before
	public void getListValues() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties p = new Properties();
		p.load(inputStream);
		listValues =  Arrays.stream(p.getProperty("value.characters").split(":"))
				    .map(r -> r.split(","))  
				  	.map(s -> Pair.of(s[0], Integer.valueOf(s[1])))
				  	.collect(Collectors.toList());
	}
	
	@Test
	public void createDeckandGetCards() {
		Deck generateDeck = new SimpleDeck(listValues);
		assertEquals(52, generateDeck.getCards().size());	
	}
	
	@Test
	public void getRandomCard() {
		Deck generateDeck = new SimpleDeck(listValues);
		assertNotNull(generateDeck.nextRandomCard());
	}
}
