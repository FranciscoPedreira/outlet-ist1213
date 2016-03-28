package rest.menu.manager.restaurant;

import java.util.*;

import java.lang.Object;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.Restaurante;
import rest.core.PratoDoDia;

import rest.textui.restaurant.MenuEntry;
import rest.textui.restaurant.Message;

/**
 * Class <code>ShowDishesOfTheDay</code> is a command for listing all dishes of the day.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowDishesOfTheDay extends Command<Restaurante> {
    /**
     */
    public ShowDishesOfTheDay(Restaurante restaurante) {
	super(false, MenuEntry.SHOW_DISHES_OF_THE_DAY, restaurante);
    }
    class CompareNome implements Comparator<PratoDoDia> {
	public int compare(PratoDoDia r1, PratoDoDia r2) {
	    String n1 = r1.getAlimento().getName();
	    String n2 = r2.getAlimento().getName();

	    return n1.compareToIgnoreCase(n2);
	}
    }
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() {
	Display d = new Display();
	List<PratoDoDia> pratosOrdenados = entity().getDishOfTheDay();
	Collections.sort(pratosOrdenados, new CompareNome());
	for (PratoDoDia pdd: pratosOrdenados)
	    d.addNewLine(pdd.toString());
	d.display();
    }
}
