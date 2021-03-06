package rest.core;

import java.io.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;

import rest.textui.food.Message;

import rest.core.alimento.*;

public class PratoDoDia extends Observable implements Serializable {

    //Atributo
    
    private Restaurante _restaurante;
    private String _classe;
    private Alimento _alimento;
    private int _preco;
    private int _desconto;
    private boolean _available;
    private int _nVezesVendido;
    private int _quantidade;

    //Construtor

    public PratoDoDia (Restaurante restaurante, Alimento alimento,int quantidade, int preco) {
	_restaurante = restaurante;
	_alimento = alimento;
	_desconto = 0;
	_available = false;
	_quantidade = quantidade;
	_preco = preco;

	this.addObserver(restaurante.getOutlet());
    }

    public PratoDoDia (Restaurante restaurante, Alimento alimento,int quantidade, int preco, int desconto) {
	_restaurante = restaurante;
	_alimento = alimento;
	_desconto = desconto;
	_available = false;
	_quantidade = quantidade;
	_preco = preco;

	this.addObserver(restaurante.getOutlet());
    }
 
    //Get

    public Restaurante getRestaurante() {
	return _restaurante;
    }
    
    public int getQuantidade() {
	return _quantidade;
    }
    
    public String getClasse(){
	if(_alimento.veg())
	    return Message.typeVeg();
	else
	    return Message.typeNoVeg();
    }    

    public Alimento getAlimento(){
	return _alimento;
    }

    public int getPreco(){
	return _preco;
    }

    public int getPrecoComDesconto() {
	int preco = 0;
	double precoDesconto = (getDesconto() * getPreco())/100;
	preco += (getPreco() - (int)precoDesconto);
	return preco;
    }

    public int getDesconto(){
	return _desconto;
    }

    public String getAvailable(){
	if (_available)
	    return Message.available();
	else
	    return Message.unavailable();
    }

    public int getNVezesVendido(){
	return _nVezesVendido++;
    }

    //Set

    public void setQuantidade(int doses) {
	_quantidade-=doses;
    }

    public void setDesconto(int desconto) {
	_desconto = desconto;
	setChanged();
	notifyObservers(this);
    }

    public void setAvailable(){
	_available = true;
    }

    public void setUnavailable(){
	_available = false;
    }

    public boolean testaAvailable(){
	return _available;
    }
    
    //Show

    public String showDishInOutlet() {
	return getClasse() + "|" + getAlimento().getName();
    }
    
    //toString
    
    @Override
	public String toString() {
	return getClasse() + "|" + getAlimento().getName() + "|" + getPreco() + "|" + getDesconto()  + "|" + getAvailable();
    }

}
