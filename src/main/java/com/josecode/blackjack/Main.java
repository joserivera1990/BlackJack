package com.josecode.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.generator.Judge;
import com.josecode.blackjack.generator.Player;
import com.josecode.blackjack.generator.impl.Croupier;
import com.josecode.blackjack.generator.impl.Person;
import com.josecode.blackjack.generator.impl.SimpleDeck;
import com.josecode.blackjack.generator.impl.SimpleJudge;
import com.josecode.blackjack.properties.Configuration;
import com.josecode.blackjack.util.Reader;

public final class Main {
    	
	private static final String LETTER_ASK_CARD = "X";
	
	private Main(){
		throw new AssertionError("The class Main can not be instantied");
	}
	
	public static void main(String[] args) {
		Map<String, String> phrases;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Configuration conf = new Configuration();
			Reader reader = new Reader(br);
			String language = reader.read("Choose code language: "+conf.getLanguages());
			phrases = conf.getMapMessages().get(language);
			if (phrases != null) {

				Judge judge = new SimpleJudge();	
				reader.read(phrases.get("start"));
				
				Deck deck = new SimpleDeck(conf.getValues());
		        Player person = new Person();
		        Player croupier = new Croupier();
		        judge.startingCards(person, croupier, deck);
		        String keyword = reader.read(phrases.get("askCard"));
		        if (keyword.equalsIgnoreCase(LETTER_ASK_CARD)) {
			        while (!person.addCard(deck.nextRandomCard())) {
			        	keyword = reader.read(phrases.get("askCard"));
			            if (!keyword.equalsIgnoreCase(LETTER_ASK_CARD)) {
			            	break;
			            }	           
			        }
		        } 
		        while (!croupier.addCard(deck.nextRandomCard())) {
		        	continue;
		        }
		        
		        judge.giveWinner(person,croupier,phrases);
			} else {
				System.out.println("Code wrong");
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
    
}
