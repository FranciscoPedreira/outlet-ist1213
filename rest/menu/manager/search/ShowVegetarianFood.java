package rest.menu.manager.search;
import java.util.*;

import java.lang.Object;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.Alimento;
import rest.core.GestorOutlet;

import rest.textui.search.MenuEntry;
import rest.textui.search.Message;

/**
 * Class <code>ShowVegetarianFood</code> represents a command for listing all vegeterian food.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowVegetarianFood extends Command<GestorOutlet> {
    /**
     */
    public ShowVegetarianFood(GestorOutlet outlet) {
	super(false, MenuEntry.SHOW_ALL_VEGETERIAN, outlet);
    }


    class CompareNome implements Comparator<Alimento> {
	public int compare(Alimento a1, Alimento a2) {
	    String n1 = a1.getName();
	    String n2 = a2.getName();

	    return n1.compareToIgnoreCase(n2);
	}
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() {
	List<Alimento> alimentosOrdenados = entity().getVeg();
	Collections.sort(alimentosOrdenados, new CompareNome());
	for(Alimento a : alimentosOrdenados)
	    new Display().addNewLine(a.toString()).display();
    }
}
