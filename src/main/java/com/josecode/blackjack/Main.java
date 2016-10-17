package com.josecode.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    	
	private Main(){
		throw new AssertionError("The class Main can not be instantied");
	}
	
	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Judge judge = new SimpleJudge();
			Reader reader = new Reader(br);
			reader.read("Enter para Iniciar Juego");
			Configuration conf = new Configuration();
			Deck deck = new SimpleDeck(conf.getValues());
	        Player person = new Person();
	        Player croupier = new Croupier();
	        judge.startingCards(person, croupier, deck);
	        String keyword = reader.read("Teclear x para pedir Otra carta o y para plantarse");
	        if (keyword.equalsIgnoreCase("X")) {
		        while (!person.addCard(deck.nextRandomCard())) {
		        	keyword = reader.read("Teclear x para pedir Otra carta o y para plantarse");
		            if (keyword.equalsIgnoreCase("Y")) {
		            	break;
		            }	           
		        }
	        } 
	        while (!croupier.addCard(deck.nextRandomCard())) {
	        	
	        }
	        judge.giveWinner(person,croupier);
	        
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
    
}
