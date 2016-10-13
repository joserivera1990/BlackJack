package com.josecode.blackjack.util;

import java.util.Random;

public final class Util {
    
	private Util() {
		throw new AssertionError("The class " + getClass() + " shouldn't be instantiated");
	}

	private static final Random RANDOM = new Random();
	
	public static int randomInt(int max)  {
	    return RANDOM.nextInt(max);
	 }
}
