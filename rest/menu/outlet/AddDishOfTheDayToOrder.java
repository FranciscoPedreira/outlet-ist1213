package rest.menu.outlet;

import java.util.*;

import java.lang.Object;

import java.io.IOException;

import rest.core.GestorOutlet;
import rest.core.Restaurante;
import rest.core.PratoDoDia;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.UnknownKeyException;
import rest.textui.outlet.*;

/**
 * This class implements the command that adds a dish to the order of a client.
 *
 * @version 1.0
 * @author PO
 **/

public class AddDishOfTheDayToOrder extends Command<GestorOutlet> {
    public AddDishOfTheDayToOrder(GestorOutlet outlet) {
	super(false, MenuEntry.ADD_TO_BASKET, outlet);
    }

    class CompareNome implements Comparator<Restaurante> {
	public int compare(Restaurante r1, Restaurante r2) {
	    String n1 = r1.getName();
	    String n2 = r2.getName();

	    return n1.compareToIgnoreCase(n2);
	}
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public void execute() throws InvalidOperation {
	List<Restaurante> restaurantesOrdenados= new ArrayList<Restaurante>();
	PratoDoDia pratoMaisBarato = null;
	int precoAux = (Integer.MAX_VALUE); 
	boolean restauranteValido = false;
	Display d = new Display();

	Form f = new Form();
	InputString email = new InputString(f, Message.reqClientId());
	InputString prato = new InputString(f, Message.reqDishOfTheDayName());
	InputInteger doses = new InputInteger(f, Message.reqQuantity());
	f.parse();
	
	if(!entity().existePrato(prato.value()))
	    throw new InvalidKeyException(prato.value());
	if((entity().getCliente(email.value()).getTipo().getVeg()) && (!entity().getAlimento(prato.value()).veg()))
	    throw new NotAdequateException(prato.value(), email.value());
	
	for(Restaurante r : entity().getRestaurantesComPrato(prato.value()))
	    if(r.getDish(prato.value()).testaAvailable())
		restaurantesOrdenados.add(r);
	Collections.sort(restaurantesOrdenados, new CompareNome());

	for(Restaurante r: restaurantesOrdenados) 
	    d.addNewLine(entity().showRestaurantes(r, prato.value()));

	if(restaurantesOrdenados.size() == 1) 
	    (entity().getCliente(email.value())).adicionaEncomenda(restaurantesOrdenados.get(0).getDish(prato.value()), doses.value()); 
	
	else {
	    d.display();

	    f = new Form();
	    InputString restaurante = new InputString(f, Message.reqRestId());
	    f.parse();

	    for(Restaurante r: entity().getRestaurantesComPrato(prato.value()))
		if(r.getName().equals(restaurante.value()))
		    restauranteValido = true;

	    if(!restauranteValido) {
		for(Restaurante r: entity().getRestaurantesComPrato(prato.value()))
		    if(r.getDish(prato.value()).getPrecoComDesconto() < precoAux) {
			pratoMaisBarato = r.getDish(prato.value());
			precoAux = r.getDish(prato.value()).getPrecoComDesconto();
		    }    
		(entity().getCliente(email.value())).adicionaEncomenda(pratoMaisBarato, doses.value());   
	    }

	    else 
		for(Restaurante r: entity().getRestaurantesComPrato(prato.value()))
		    if(r.getName().equals(restaurante.value()))
			(entity().getCliente(email.value())).adicionaEncomenda(r.getDish(prato.value()), doses.value());
	    
	}
    }	
}

