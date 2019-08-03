package com.ugsbo.Crypto;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;


public class Payload {

  String offen;
  String verschlüsselt;
  SecretKeySpec password;

  public Payload() {
    offen = "";
    verschlüsselt = "";

    try {
      this.setPassword("");
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (GeneralSecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  public String getOffen() {
    return offen;
  }



  public String getVerschlüsselt() {
    return verschlüsselt;
  }

  public void setOffen(String offen) {
    this.offen = offen;
  }



  public void setVerschlüsselt(String verschlüsselt) {
    this.verschlüsselt = verschlüsselt;
  }



  public void setPassword(String password)
      throws GeneralSecurityException, UnsupportedEncodingException {
    byte[] key = (password).getBytes("UTF-8");

    // aus dem Array einen Hash-Wert erzeugen mit MD5 oder SHA
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    key = sha.digest(key);

    // nur die ersten 128 bit nutzen
    key = Arrays.copyOf(key, 16);

    // der fertige Schluessel
    this.password = new SecretKeySpec(key, "AES");
  }



  public void verschlüsseln() throws NoSuchAlgorithmException, GeneralSecurityException {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, password);
    byte[] encrypted = cipher.doFinal(offen.getBytes());

    verschlüsselt = Base64.getEncoder().encodeToString(encrypted);
  }

  public void entschlüsseln() throws NoSuchAlgorithmException, GeneralSecurityException {
    byte[] text = Base64.getDecoder().decode(verschlüsselt);

    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, password);
    byte[] cipherData2 = cipher.doFinal(text);
    offen = new String(cipherData2);

  }

}
