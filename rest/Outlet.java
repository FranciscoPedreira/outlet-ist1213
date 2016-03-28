package rest;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;

import java.io.*;

import rest.core.GestorOutlet;

import rest.menu.outlet.OutletMenuBuilder;

import rest.textui.outlet.MenuEntry;
import rest.textui.outlet.Message;

public class Outlet {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	Form f = new Form();
	GestorOutlet outlet = new GestorOutlet();
	InputString nomeDoFicheiroAbrir = new InputString(f, Message.openFile());
	f.parse();
	outlet.abrir(nomeDoFicheiroAbrir.value());
	OutletMenuBuilder.menuFor(outlet);	
	f = new Form();
	InputString nomeDoFicheiroGuardar = new InputString(f,Message.saveFile());
	f.parse();
	try{
            outlet.guardar(nomeDoFicheiroGuardar.value());
	}catch (IOException i){}
    }
}
