package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;

import java.io.*;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

/**
 * Class <code>SaveAs</code> represents a command to save the current state of application in a new file
 *
 * @version 1.0
 * @author PO
 **/

public class SaveAs extends Command<GestorOutlet> {
    /**
     */
    public SaveAs(GestorOutlet outlet) {
	super(false, MenuEntry.SAVE_AS, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public final void execute() throws InvalidOperation {

   	Form f = new Form();
	InputString nome = new InputString(f, Message.saveAs());
	f.parse();
	entity().setNomeDoFicheiro(nome.value());
	try{
	    entity().guardar(entity().getNomeDoFicheiro());
	}catch(Exception e){
	}
	
    }
}
