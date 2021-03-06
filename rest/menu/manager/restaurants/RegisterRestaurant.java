package rest.menu.manager.restaurants;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;
import rest.core.Restaurante;

import rest.textui.restaurants.MenuEntry;
import rest.textui.restaurants.Message;
import rest.textui.DuplicateKeyException;

/**
 * Class <code>ManageRestaurant</code> represents a command for registering a new restaurant.
 *
 * @version 1.0
 * @author PO
 **/

public class RegisterRestaurant extends Command<GestorOutlet> {
    /**
     */
    public RegisterRestaurant(GestorOutlet outlet) {
	super(false, MenuEntry.REGISTER_RESTAURANT, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() throws InvalidOperation {
	Form f = new Form();
	InputString restaurantName = new InputString(f, Message.reqName());
	InputString restaurantEmail = new InputString(f, Message.reqEmail());
	f.parse();
	for(Restaurante r : entity().getRestaurants())
	    if(r.getName().equals(restaurantName.value()))
		throw new DuplicateKeyException(restaurantName.value());
	entity().adicionaRestaurante(new Restaurante(entity(),restaurantName.value(),restaurantEmail.value()));
	
    }
}
