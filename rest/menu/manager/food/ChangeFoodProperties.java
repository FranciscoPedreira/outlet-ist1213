package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.Alimento;
import rest.core.alimento.AlimentoSimples;
import rest.core.GestorOutlet;

import rest.textui.UnknownKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;

import rest.menu.manager.ManagerMenuBuilder;

/**
 * This class implements the command that updates the properties of food.
 *
 * @version 1.0
 * @author PO
 **/

public class ChangeFoodProperties extends Command<GestorOutlet> {

    public ChangeFoodProperties(GestorOutlet outlet) {
	super(false, MenuEntry.CHANGE_FOOD, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public void execute() throws InvalidOperation {
	Form f = new Form();

	InputString foodName = new InputString(f, Message.reqKey());
	f.parse();

	if(entity().existeAlimento(foodName.value()) == false)
	    throw new UnknownKeyException(foodName.value());

	f = new Form();

	InputInteger calorias = new InputInteger(f, Message.reqCalories());
	f.parse();

	((AlimentoSimples)(entity().getAlimento(foodName.value()))).setCalories(calorias.value());
    }
}
