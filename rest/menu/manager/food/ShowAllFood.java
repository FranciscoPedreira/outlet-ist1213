package rest.menu.manager.food;

import java.util.*;

import java.lang.Object;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;

import rest.core.GestorOutlet;
import rest.core.Alimento;

import rest.textui.food.MenuEntry;
import rest.textui.food.Message;

import rest.menu.manager.ManagerMenuBuilder;
/**
 * This class implements the command for listing all food.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowAllFood extends Command<GestorOutlet> {

    public ShowAllFood(GestorOutlet outlet) {
	super(false, MenuEntry.LIST_FOOD, outlet);
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
	public void execute() throws InvalidOperation {
	Display d = new Display();

	List<Alimento> alimentosOrdenados = entity().getFood();
	Collections.sort(alimentosOrdenados, new CompareNome());

	for(Alimento a : alimentosOrdenados)
	    d.addNewLine(a.toString());

	d.display();
    }
}
