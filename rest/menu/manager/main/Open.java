package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.core.GestorOutlet;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

import java.io.*;
//import java.io.Exception;
import java.io.IOException;
import java.lang.ClassNotFoundException;
/**
 * Class <code>Open</code> represents a command to open a file.
 *
 * @version 1.0
 * @author PO
 **/

public class Open extends Command<GestorOutlet> {
    /**
     */
    public Open(GestorOutlet outlet) {
	super(false, MenuEntry.OPEN, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
	public final void execute() throws InvalidOperation{
	Form f = new Form();
	InputString file = new InputString(f, Message.openFile());
	f.parse();
	try {
	    entity().abrir(file.value());
	} catch(Exception e) {
	    (new Display()).addNewLine(Message.fileNotFound(file.value()).toString()).display();
	}
    }
}
