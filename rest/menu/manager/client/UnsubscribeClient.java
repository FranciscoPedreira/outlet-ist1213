package rest.menu.manager.client;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;

import rest.textui.DuplicateKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;

/**
 * This class implements the command that unsubscribes a client.
 *
 * @version 1.0
 * @author PO
 **/

public class UnsubscribeClient extends Command<GestorOutlet> {
    public UnsubscribeClient(GestorOutlet outlet) {
	super(false, MenuEntry.UNSUBSCRIBE_ALERT_LIST, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public void execute() throws InvalidOperation {
	Form f = new Form();

	InputString email = new InputString(f, Message.reqKey());
	f.parse();

	f = new Form();

	InputString tipo = new InputString(f, Message.reqLeaveAlertType());

	do {
	    f.parse();	
	} while(!tipo.value().equals(Message.alertTypeDiscount()) && !tipo.value().equals(Message.alertTypeNovelty()));

	if(tipo.value().equals(Message.alertTypeDiscount()))
	    entity().removeListaReducao(entity().getCliente(email.value()));
	else
	    entity().removeListaNovidade(entity().getCliente(email.value()));
    }
}
