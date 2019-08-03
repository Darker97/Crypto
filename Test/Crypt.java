/**
 * 
 */
package com.ugsbo.Crypto;

import com.ugsbo.Crypto.*;
import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import org.junit.Before;
import org.junit.Test;

public class Crypt {


  private Payload workingobjekt;

  @Before
  public void setUp() throws Exception {
    workingobjekt = new Payload();
  }

  @Test
  public void offenIstAnders() {

    String eingabe = "TestText";
    String ergebnis;
    String password = "";

    try {
      workingobjekt.setOffen(eingabe);
      workingobjekt.setPassword(password);
      workingobjekt.entschlüsseln();
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    ergebnis = workingobjekt.getVerschlüsselt();

    assertNotEquals("unterschidliche Texte", eingabe, ergebnis);
  }

  @Test
  public void verUndEntschlüsseln() {

    String password = "Test";
    String eingabe = "TestText";
    String ergebnis;

    try {
      workingobjekt.setOffen(eingabe);
      workingobjekt.setPassword(password);
      workingobjekt.verschlüsseln();
      workingobjekt.entschlüsseln();
    } catch (GeneralSecurityException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    ergebnis = workingobjekt.getOffen();

    assertEquals("das entschlüsselte Test Wort", ergebnis, eingabe);
  }

}
