package rest.menu.manager.restaurants;

import java.util.*;

import java.lang.Object;

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

/**
 * Class <code>ShowAllRestaurants</code> represents a command for listing all registered restaurants.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowAllRestaurants extends Command<GestorOutlet> {
    /**
     */
    public ShowAllRestaurants(GestorOutlet outlet) {
	super(false, MenuEntry.SHOW_RESTAURANTS, outlet);
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
	public final void execute() throws InvalidOperation {
	Display d = new Display();
	List<Restaurante> restaurantesOrdenados = entity().getRestaurants();
	Collections.sort(restaurantesOrdenados, new CompareNome());
	for(Restaurante r: restaurantesOrdenados) 
	    d.addNewLine(r.toString());
	d.display();
    }

}
