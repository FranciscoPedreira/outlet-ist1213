package rest.menu.manager.restaurant;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;
import rest.core.GestorOutlet;
import rest.core.Restaurante;
import rest.textui.restaurant.*;
import rest.textui.UnknownKeyException;

/**
 * Class <code>ChangeDishOfTheDayDiscount</code> is a command for changing
 * the discount of a selected dish to the day.
 *
 * @version 1.0
 * @author PO
 **/

public class ChangeDishOfTheDayDiscount extends Command<Restaurante> {
    /**
     */
    public ChangeDishOfTheDayDiscount(Restaurante restaurante) {
	super(false, MenuEntry.CHANGE_DISCOUNT, restaurante);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() throws InvalidOperation {
	Form f = new Form();
	Display d = new Display();
	InputString nome = new InputString(f, Message.reqKey());
	f.parse();
	if(!entity().pratoDisponivel(nome.value()))
	    throw new InvalidKeyException(nome.value());
	f = new Form();
	InputInteger desconto = new InputInteger(f, Message.reqDiscount());
	f.parse();
	if(desconto.value() >= 0 && desconto.value() <= 100) 
	    entity().setDesconto(entity().getDish(nome.value()).getAlimento(), desconto.value());	
    }
}
