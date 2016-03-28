package rest.menu.manager.main;

import rest.core.GestorOutlet;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.menu.manager.ManagerMenuBuilder;
import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

/**
 * Class <code>OpenFoodMenu</code> represents a command to the food management menu.
 *
 * @version 1.0
 * @author PO
 **/

public class OpenFoodMenu extends Command<GestorOutlet> {
    /**
     */
    private GestorOutlet _outletActual;

    public OpenFoodMenu(GestorOutlet outlet) {
	super(false, MenuEntry.MENU_FOOD, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public final void execute() throws InvalidOperation {
	ManagerMenuBuilder.openFoodMenu(entity());
    }
}
