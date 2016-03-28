package rest.menu.outlet;

import rest.core.GestorOutlet;

/**
 * This class implements the menu of the outlet application.
 **/

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import rest.textui.outlet.MenuEntry;

public final class OutletMenuBuilder {

    public static void menuFor(GestorOutlet outlet) {
	Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
		new ShowDishesOfTheDay(outlet),
		new AddDishOfTheDayToOrder(outlet),
		new CheckoutOrder(outlet),
	    });
	menu.open();
    }
}
