package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

import rest.menu.manager.ManagerMenuBuilder;
/**
 * Class <code>OpenrestaurantsMenu</code> represents a command to open the restaurant management menu.
 *
 * @version 1.0
 * @author PO
 **/

public class OpenRestaurantsMenu extends Command<GestorOutlet> {
    /**
     */
    private GestorOutlet _outletActual;

    public OpenRestaurantsMenu(GestorOutlet outlet) {
	super(false, MenuEntry.MENU_RESTAURANTS, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public final void execute() throws InvalidOperation {
	ManagerMenuBuilder.openRestaurantsMenu(entity());
    }
}
