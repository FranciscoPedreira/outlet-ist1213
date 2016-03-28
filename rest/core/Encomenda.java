package rest.core;

import rest.core.PratoDoDia;

import java.io.*;

public class Encomenda implements Serializable{

    //Atributo

    private PratoDoDia _pdd;
    private int _doses;

    //Construtor
    
    public Encomenda(PratoDoDia pdd, int doses) {
	_pdd = pdd;
	_doses = doses;
    }
    
    //Get
    
    public PratoDoDia getPrato() {
	return _pdd;
    }
    
    public int getDoses() {
	return _doses;
    }

}