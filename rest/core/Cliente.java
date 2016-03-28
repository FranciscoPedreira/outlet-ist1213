package rest.core;

import java.io.*;

import java.util.List;
import java.util.ArrayList;

import rest.textui.clients.Message;

import rest.core.Encomenda;
import rest.core.Alerta;
import rest.core.cliente.*;
import rest.core.cliente.tipoDeCliente.*;

public class Cliente implements Serializable{

    //Atributo

    private GestorOutlet _outlet;
    private int _id;
    private String _email;
    private String _nome;
    private TipoDeCliente _tipoDeCliente;
    private int _nrEncomendas;
    private int _nrPratosDia;
    private int _dinheiroGasto;
    private List<Encomenda> _encomenda;
    private List<Alerta> _inbox;

    //Construtor

    public Cliente(GestorOutlet outlet, String email, String nome, String tipoDeCliente) {
	_outlet = outlet;
	_email = email;
	_nome = nome;
	setType(tipoDeCliente);
	_nrEncomendas = 0;
	_nrPratosDia = 0;
	_dinheiroGasto = 0;
	_encomenda = new ArrayList<Encomenda>();
	_inbox = new ArrayList<Alerta>();
    }

    //Alerta
    
    public void recebeAlerta(Alerta alerta) {
	_inbox.add(alerta);
    }

    // Compra

    public void compra(PratoDoDia pdd, int doses) {
	double compraActual=0;
	_nrPratosDia += doses;
	double precoDesconto = (pdd.getPreco() * pdd.getDesconto()) / 100.00;
	compraActual += pdd.getPreco() - precoDesconto;
	compraActual*=doses;
	_dinheiroGasto += compraActual;
    }

    public void finalizaCompra() {
	_encomenda.clear();
	_nrEncomendas++;
    }

    //Adiciona
    
    public void adicionaEncomenda(PratoDoDia pdd, int doses) {
	_encomenda.add(new Encomenda(pdd, doses));
    }

    //Get
   
    public List<Alerta> getInbox() {
	return _inbox;
    }

    public List<Encomenda> getEncomenda() {
	return _encomenda;
    }
    
    public TipoDeCliente getTipo() {
	return _tipoDeCliente;
    }
    
    public String getType() {
	if (_tipoDeCliente instanceof Omnivoro)
	    return Message.clientTypeOmnivorous();
	else
	    return Message.clientTypeVegetarian();
    }
	
    public String getName() {
	return _nome;
    }
	
    public String getEmail() {
	return _email;
    }

    public int getOrders() {
	return _nrEncomendas;
    }

    public int getDodt() {
	return _nrPratosDia;
    }

    public int getSpent() {
	return _dinheiroGasto;
    }

    //Set

    public void setType(String type) {
	if(type.equals(Message.clientTypeOmnivorous())) 
	    _tipoDeCliente = new Omnivoro(this);
	else
	    _tipoDeCliente = new Vegetariano(this);	
    }

    //toString

    @Override
	public String toString() {
	return getType() + "|" + getName() + "|" + getEmail() + "|" + getOrders()  + "|" + getDodt() + "|" + getSpent();
    }	 
}
	
