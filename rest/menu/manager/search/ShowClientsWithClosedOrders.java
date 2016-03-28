package rest.menu.manager.search;
import java.util.*;

import java.lang.Object;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;
import rest.core.GestorOutlet;
import rest.core.Cliente;

import rest.textui.search.MenuEntry;
import rest.textui.search.Message;

/**
 * Class <code>ShowClientsWithClosedOrders</code> represents a command for listing all clients
 *  without any orders.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowClientsWithClosedOrders extends Command<GestorOutlet> {
    /**
     */
    public ShowClientsWithClosedOrders(GestorOutlet outlet) {
	super(false, MenuEntry.SHOW_CLIENTS_WITHOUT_ORDERS, outlet);
    }


    class CompareEmail implements Comparator<Cliente> {
	public int compare(Cliente c1, Cliente c2) {
	    String e1 = c1.getEmail();
	    String e2 = c2.getEmail();

	    return e1.compareToIgnoreCase(e2);
	}
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() {
	Display d = new Display();
	List<Cliente> clientesOrdenados = entity().getClientesComEncom();
	Collections.sort(clientesOrdenados, new CompareEmail());
	for(Cliente c : clientesOrdenados)
	    d.addNewLine(c.toString());
	d.display();
    }
}
