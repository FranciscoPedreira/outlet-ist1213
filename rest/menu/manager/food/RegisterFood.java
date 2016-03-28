package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;
import rest.core.Alimento;
import rest.core.alimento.AlimentoSimples;

import rest.textui.DuplicateKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;

import rest.menu.manager.ManagerMenuBuilder;
/**
 * This class implements the command that register a new food.
 *
 * @version 1.0
 * @author PO
 **/

public class RegisterFood extends Command<GestorOutlet> {
    public RegisterFood(GestorOutlet outlet) {
	super(false, MenuEntry.REGISTER_FOOD, outlet);
    }
	
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public void execute() throws InvalidOperation {
	Form f = new Form();

	InputString foodType = new InputString(f, Message.reqType());
	do  {
	    f.parse();
	} while(!foodType.value().equals(Message.typeMeat()) && !foodType.value().equals(Message.typeFish()) && !foodType.value().equals(Message.typeVegetable()));
	f = new Form();

	InputString foodName = new InputString(f, Message.reqName());
	InputInteger foodCalories = new InputInteger(f, Message.reqCalories());
	f.parse();

	for(Alimento a : entity().getFood())
	    if(a.getName().equals(foodName.value()))
		throw new DuplicateKeyException(foodName.value());

	entity().adicionaAlimento(new AlimentoSimples(entity(),foodType.value(),foodName.value(),foodCalories.value()));
    }
}
