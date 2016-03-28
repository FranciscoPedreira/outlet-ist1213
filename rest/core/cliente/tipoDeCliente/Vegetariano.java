package rest.core.cliente.tipoDeCliente;

import java.io.*;

import rest.core.cliente.TipoDeCliente;
import rest.core.Cliente;

public class Vegetariano extends TipoDeCliente implements Serializable{
	
    //Construtor
 
    public Vegetariano(Cliente cliente){
	_veg = true;
    }

}
		
