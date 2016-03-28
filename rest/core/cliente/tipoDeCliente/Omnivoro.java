package rest.core.cliente.tipoDeCliente;

import java.io.*;

import rest.core.cliente.TipoDeCliente;
import rest.core.Cliente;

public class Omnivoro extends TipoDeCliente implements Serializable {
	
    //Construtor
    
    public Omnivoro(Cliente cliente) {
	_veg = false;
    }

}
		
