package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;
import rest.core.Alimento;
import rest.core.alimento.AlimentoAgregado;
import rest.core.alimento.AlimentoSimples;

import rest.textui.UnknownKeyException;
import rest.textui.food.InvalidKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;

import rest.menu.manager.ManagerMenuBuilder;

import java.util.List;
import java.util.ArrayList;
/**
 * This class implements the command for describing a prepared food.
 *
 * @version 1.0
 * @author PO
 **/

public class DescribePreparedFood extends Command<GestorOutlet> {
    public DescribePreparedFood(GestorOutlet outlet) {
	super(false, MenuEntry.DESCRIBE_PREPARED, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public void execute() throws InvalidOperation {
	Form f = new Form();
	Display d = new Display();
	List<String> descricao = new ArrayList<String>();
	InputString nome = new InputString(f, Message.reqKey());
	f.parse();
	if(!entity().existeAlimento(nome.value()))
	    throw new UnknownKeyException(nome.value());

	if((entity().getAlimento(nome.value())) instanceof AlimentoSimples)
	    throw new InvalidKeyException(nome.value());

	for(String s : ((AlimentoAgregado)(entity().getAlimento(nome.value()))).getDescricao(descricao))
	    d.addNewLine(s);
	d.display();
    }
}
    
