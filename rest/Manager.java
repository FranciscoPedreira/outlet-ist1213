package rest;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;

import java.io.*;

import rest.core.GestorOutlet;

import rest.menu.manager.ManagerMenuBuilder;

import rest.textui.manager.*;

public class Manager {

    public static void main(String[] args) {
	GestorOutlet outlet = new GestorOutlet();

	String filename = System.getProperty("Import");
	if(filename != null) outlet.parseInputFile(filename);

	ManagerMenuBuilder menu = new ManagerMenuBuilder();
	menu.openMainMenu(outlet);
    }
}
