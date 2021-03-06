package rest.menu.manager.client;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;

import rest.textui.UnknownKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;

/**
 * This class implements the command that subscribes a client.
 *
 * @version 1.0
 * @author PO
 **/

public class SubscribeClient extends Command<GestorOutlet> {
    public SubscribeClient(GestorOutlet outlet) {
	super(false, MenuEntry.SUBSCRIBE_ALERT_LIST, outlet);
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
	InputString tipo = new InputString(f, Message.reqJoinAlertType());
	do {
	    f.parse();	
	} while(!tipo.value().equals(Message.alertTypeDiscount()) &&!tipo.value().equals(Message.alertTypeNovelty()));

	if(tipo.value().equals(Message.alertTypeDiscount()))
	    entity().adicionaListaReducao(entity().getCliente(email.value()));
	else
	    entity().adicionaListaNovidade(entity().getCliente(email.value()));
    }
}
