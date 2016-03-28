package rest.core;

import java.io.*;

public class Alerta implements Serializable{

    //Atributo

    private String _mensagem;
    private String _tipo;

    //Construtor
    
    public Alerta(String mensagem, String tipo) {

	_mensagem = mensagem;
	_tipo = tipo;
    }
    
    //Get
    
    public String getMensagem() {
	return _mensagem;
    }
    
    public String getTipo() {
	return _tipo;
    }

    //toString
    
    public String toString() {
	return getTipo() + "|" + getMensagem();
    }
    
}