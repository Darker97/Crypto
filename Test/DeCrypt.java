package com.ugsbo.Crypto;

import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import com.ugsbo.Crypto.*;
import org.junit.Before;
import org.junit.Test;

public class DeCrypt {

  private Payload workingobjekt;

  @Before
  public void setUp() throws Exception {
    workingobjekt = new Payload();
  }

  @Test
  public void verschlüsseltIstAnders() {

    String eingabe = "TestText";
    String password = "Test";
    String ergebnis;

    try {
      workingobjekt.setVerschlüsselt(eingabe);
      workingobjekt.setPassword(password);
      workingobjekt.entschlüsseln();
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    ergebnis = workingobjekt.getOffen();

    assertNotEquals("unterschidliche Texte", eingabe, ergebnis);
  }

  @Test
  public void entUndVerschlüsseln() {

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
