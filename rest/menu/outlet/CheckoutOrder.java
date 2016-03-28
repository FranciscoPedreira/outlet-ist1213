package rest.menu.outlet;

import rest.core.GestorOutlet;
import rest.core.Encomenda;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.UnknownKeyException;
import rest.textui.outlet.MenuEntry;
import rest.textui.outlet.Message;

/**
 * This class implements the command that finalizes an order.
 *
 * @version 1.0
 * @author PO
 **/

public class CheckoutOrder extends Command<GestorOutlet> {
    public CheckoutOrder(GestorOutlet outlet) {
	super(false, MenuEntry.CHECKOUT, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public void execute() throws InvalidOperation {
	Form f = new Form();
	InputString email = new InputString(f, Message.reqClientId());
	f.parse();
	
	for(Encomenda e : entity().getCliente(email.value()).getEncomenda()) {
	    e.getPrato().getRestaurante().compra(e.getPrato(), e.getDoses());
	    entity().getCliente(email.value()).compra(e.getPrato(), e.getDoses());
	}
	entity().getCliente(email.value()).finalizaCompra();
	
    }
}
