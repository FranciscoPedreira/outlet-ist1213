package rest.menu.manager.main;

import rest.core.GestorOutlet;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

/**
 * Class <code>Save</code> represents a command to save the current state of application in the file
 * associated to the application.
 *
 * @version 1.0
 * @author PO
 **/

public class Save extends Command<GestorOutlet> {
    /**
     */
    public Save(GestorOutlet outlet) {
	super(false, MenuEntry.SAVE, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public final void execute() throws InvalidOperation {
	if(entity().getNomeDoFicheiro().equals("")){
	    Form f = new Form();
	    InputString nome = new InputString(f, Message.newSaveAs());
	    f.parse();
	    entity().setNomeDoFicheiro(nome.value());
	} 
	
	try{
	   
	    entity().guardar(entity().getNomeDoFicheiro());
	}catch(Exception e){
	}
    }
}
