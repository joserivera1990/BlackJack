package com.josecode.blackjack.util;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class Reader {
    
	private BufferedReader br;
	
    public Reader(BufferedReader br) {
           this.br = br;
    }

    public String read(String message) {
        System.out.println(message);
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("Ocurrió un error mientras se leía la línea. Intentelo de nuevo");
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

}