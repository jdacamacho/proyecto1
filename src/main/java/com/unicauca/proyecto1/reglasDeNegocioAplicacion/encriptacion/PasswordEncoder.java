package com.unicauca.proyecto1.reglasDeNegocioAplicacion.encriptacion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordEncoder {

    private static final String FIXED_SALT = "8";

    public PasswordEncoder(){

    }

    public String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(FIXED_SALT.getBytes());
            byte[] bytes = md.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String obtenerContraseñaEncriptada(String password){
        return encodePassword(password);
    }
    
}
