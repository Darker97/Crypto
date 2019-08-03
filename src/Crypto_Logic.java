package com.ugsbo.Crypto;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class Crypto_Logic {

  public static void main(String[] args) throws UnsupportedEncodingException, GeneralSecurityException {
    // TODO Auto-generated method stub
    String test = "Hallo, mein Name ist Christian";
        
    Payload temp = new Payload();
    temp.setOffen(test);
    temp.setPassword("geheim");
    temp.verschlüsseln();
    System.out.println(temp.getVerschlüsselt());
    
    temp.entschlüsseln();
    System.out.println(temp.getOffen());
  }

}
