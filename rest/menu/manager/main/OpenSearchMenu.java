package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;
import rest.menu.manager.ManagerMenuBuilder;
import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

/**
 * Class <code>OpenSearchMenu</code> represents a command to the search menu.
 *
 * @version 1.0
 * @author PO
 **/

public class OpenSearchMenu extends Command<GestorOutlet> {
    /**
     */
    private GestorOutlet _outletActual;
    public OpenSearchMenu(GestorOutlet outlet) {
	super(false, MenuEntry.MENU_SEARCH, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public final void execute() throws InvalidOperation {
	ManagerMenuBuilder.openSearchMenu(entity());
	
    }
}
