package com.josecode.blackjack.util;

public enum Stick {
   SWORD("S"),
   HEART("H"),
   DIAMOND("D"),
   CLOVERS("C");
   
	private Stick(String id) {
		this.id = id;
	}

	private String id;
	
	public String getId() {
		return id;
	}
	
	public static Stick getEnum(String id) {
		for (Stick value : Stick.values()) {
			if (value.id.equals(id)) {
				return value;
			}
		}	
		throw new AssertionError("Value: "+id + " no exist");
		
	}
}
