package rest.menu.manager.client;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;
import rest.core.Cliente;

import rest.textui.DuplicateKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;

/**
 * This class implements the command that registers a client.
 *
 * @version 1.0
 * @author PO
 **/

public class RegisterClient extends Command<GestorOutlet> {
    public RegisterClient(GestorOutlet outlet) {
	super(false, MenuEntry.REGISTER_CLIENT, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public void execute() throws InvalidOperation {
	Form f = new Form();

	InputString clientType = new InputString(f, Message.reqType());

	do  {
	    f.parse();
	} while(!clientType.value().equals(Message.clientTypeOmnivorous()) && !clientType.value().equals(Message.clientTypeVegetarian()));

	f = new Form();

	InputString clientName = new InputString(f, Message.reqName());
	InputString clientEmail = new InputString(f, Message.reqEmail());
	f.parse();

	for(Cliente c : entity().getClientes())
	    if(c.getEmail().equals(clientEmail.value()))
		throw new DuplicateKeyException(clientEmail.value());

	entity().adicionaCliente(new Cliente(entity(),clientEmail.value(),clientName.value(),clientType.value()));
	
    }
}
