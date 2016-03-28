package rest.core.cliente;

import java.io.*;

import rest.core.cliente.tipoDeCliente.*;
 
public abstract class TipoDeCliente implements Serializable {
    
    protected boolean _veg;

    public boolean getVeg() {
	return _veg;
    }
    
}


