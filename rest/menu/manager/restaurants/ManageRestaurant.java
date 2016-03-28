package rest.menu.manager.restaurants;

import java.io.IOException;

import rest.menu.manager.ManagerMenuBuilder;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;
import rest.core.Restaurante;

import rest.textui.restaurants.MenuEntry;
import rest.textui.restaurants.Message;
import rest.textui.UnknownKeyException;

/**
 * Class <code>ManageRestaurant</code> represents a command for openning the restaurant menu for
 * a selected restaurant.
 *
 * @version 1.0
 * @author PO
 **/

public class ManageRestaurant extends Command<GestorOutlet> {
    /**
     */
    private GestorOutlet _outletActual;

    public ManageRestaurant(GestorOutlet outlet) {
	super(false, MenuEntry.OPEN_RESTAURANT_MENU, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() throws InvalidOperation {
	boolean existeRest = false;
	Form f = new Form();
	InputString restaurantKey = new InputString(f, Message.reqKey());
	f.parse();
	for(Restaurante r : entity().getRestaurants()) 
	    if(r.getName().equals(restaurantKey.value())){
		ManagerMenuBuilder.openRestaurantMenu(r);
		existeRest = true;
	    }
	if(!existeRest)
	    throw new UnknownKeyException(restaurantKey.value());
    }
}
