package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

import rest.core.GestorOutlet;
import rest.menu.manager.ManagerMenuBuilder;

import java.io.*;

/**
 * Class <code>New</code> represents a command to create a new application. The state of the previous
 * application may be stored.
 *
 * @version 1.0
 * @author PO
 **/

public class New extends Command<GestorOutlet> {
    /**
     */
    public New(GestorOutlet outlet) {
	super(false, MenuEntry.NEW, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    @Override
	public final void execute() throws InvalidOperation{
	Boolean confirmacao = false;
	if(entity().getAlteracao() ==true) {
	    Form f1 = new Form();
	    InputBoolean confirma = new InputBoolean(f1, Message.saveBeforeExit());
	    confirmacao = confirma.value();
	    f1.parse();
	}
	if(confirmacao  == true) {
	    if(entity().getNomeDoFicheiro().equals("")){
		Form f2 = new Form();
		InputString nome = new InputString(f2, Message.newSaveAs());
		f2.parse();
		entity().setNomeDoFicheiro(nome.value());
	    }
	    try{
		entity().guardar(entity().getNomeDoFicheiro());
	    }catch (IOException i){
	    }
	}
	
	else {
	    entity().reset();	   
	}
    }
}
