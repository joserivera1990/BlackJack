package com.josecode.blackjack.model;

import java.util.Objects;

public class Language {
    
	private final String code;

	private final String name;
	
	private Language(final String code, final String name) {
		this.code = code;
		this.name = name;
	}
	
	public static Language of(final String code, final String name) {
		return new Language(code, name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code,name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "code=" + code + ", name=" + name;
	}
	
	
}
