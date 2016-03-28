package rest.menu.manager.search;

import rest.core.GestorOutlet;

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

import rest.textui.search.MenuEntry;
import rest.textui.search.Message;

/**
 * Class <code>ShowRestaurantsWithDiscounts</code> represents a command for listing all
 * restaurants with discouts.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowRestaurantsWithDiscounts extends Command<GestorOutlet> {
    /**
     */
    public ShowRestaurantsWithDiscounts(GestorOutlet outlet) {
	super(false, MenuEntry.SHOW_RESTAURANTS_WITH_DISCOUNTS, outlet);
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
	public final void execute() {
	Display d = new Display();
	List<Restaurante> restaurantesOrdenados = entity().getRestComDesc();
	if(restaurantesOrdenados.size() != 0){
	    Collections.sort(restaurantesOrdenados, new CompareNome());
	    for(Restaurante r: restaurantesOrdenados) 
		d.addNewLine(r.toString());
	    d.display();
	}
    }

}
