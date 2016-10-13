package com.josecode.blackjack;

import com.josecode.blackjack.generator.Deck;
import com.josecode.blackjack.generator.impl.SimpleDeck;

public final class Main {

	private Main(){
		throw new AssertionError("The class Main can not be instantied");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Deck generator = new SimpleDeck();
		System.out.println("d");
		System.out.println(generator.nextRandomCard());

	}

}
