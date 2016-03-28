package rest.menu.manager.restaurant;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;
import rest.core.GestorOutlet;
import rest.core.Restaurante;
import rest.textui.restaurant.*;

/**
 * Class <code>AddDishOfTheDayToOutlet</code> is a command for adding
 * a selected dish to the dishes of the day of the outlet.
 *
 * @version 1.0
 * @author PO
 **/

public class AddDishOfTheDayToOutlet extends Command<Restaurante> {
    /**
     */
    public AddDishOfTheDayToOutlet(Restaurante restaurante) {
	super(false, MenuEntry.MAKE_AVAILABLE, restaurante);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() throws InvalidOperation {
	boolean estado=false;
	Form f = new Form();

	InputString nameFood = new InputString(f, Message.reqKey());
	f.parse();

	String nFood = nameFood.value();

	estado = (entity().adicionaAoOutlet(nFood));

	if(!estado)
	    throw new InvalidKeyException(nameFood.value());
    }
}
