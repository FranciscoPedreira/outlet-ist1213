package rest.menu.manager.client;

import java.util.*;

import java.lang.Object;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;

import rest.core.GestorOutlet;
import rest.core.Cliente;

import rest.textui.DuplicateKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;

/**
 * This class implements the command that shows all clients registered with this application.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowClients extends Command<GestorOutlet> {
    public ShowClients(GestorOutlet outlet) {
	super(false, MenuEntry.SHOW_ALL_CLIENTS, outlet);
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
	public void execute() throws InvalidOperation {
	Display d = new Display();

	List<Cliente> clientesOrdenados = entity().getClientes();
	Collections.sort(clientesOrdenados, new CompareEmail());

	for(Cliente c : clientesOrdenados)
	    d.addNewLine(c.toString());

	d.display();
    }
}
