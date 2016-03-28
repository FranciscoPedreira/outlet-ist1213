package rest.menu.manager.main;

import rest.core.GestorOutlet;

import rest.menu.manager.ManagerMenuBuilder;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

/**
 * Class <code>OpenClientsMenu</code> represents a command to open the client menu.
 *
 * @version 1.0
 * @author PO
 **/
public class OpenClientsMenu extends Command<GestorOutlet> {
    private GestorOutlet _outletActual;
    /**
     */
    public OpenClientsMenu(GestorOutlet outlet) {
	super(false, MenuEntry.MENU_CLIENTS, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public final void execute() throws InvalidOperation {
	ManagerMenuBuilder.openClientMenu(entity());
    }
}
