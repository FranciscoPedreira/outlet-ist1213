package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.util.List;
import java.util.ArrayList;

import rest.menu.manager.ManagerMenuBuilder;

import rest.core.GestorOutlet;
import rest.core.alimento.AlimentoAgregado;
import rest.core.Alimento;
import rest.core.alimento.AlimentoSimples;

import rest.textui.DuplicateKeyException;
import rest.textui.UnknownKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;
import rest.textui.food.PercentageTooHighException;


public class RegisterPreparedFood extends Command<GestorOutlet> {

    public RegisterPreparedFood(GestorOutlet outlet) {

	super(false, MenuEntry.REGISTER_PREPRARED, outlet);
    }

    @Override
	public void execute() throws InvalidOperation {
	List<Alimento> alimentos = new ArrayList<Alimento>();
	List<String> alimentosAux = new ArrayList<String>(); 
	List<Integer> percentagens = new ArrayList<Integer>();
	List<Integer> percentagensAux = new ArrayList<Integer>();
	String tipo = new String();
	int percentagemTotal = 0;

	Form f = new Form();
	InputString foodName = new InputString(f, Message.reqName());
	f.parse();

	for(Alimento a : entity().getFood()) {
	    
	    if(foodName.value().equals(a.getName()))
		throw new DuplicateKeyException(foodName.value());
	} 

	do {	
	    f = new Form();
	    InputString foodKey = new InputString(f, Message.reqKey());
	    f.parse();
	    if(!entity().existeAlimento(foodKey.value()))
		throw new UnknownKeyException(foodKey.value());
	    f = new Form();
	    InputInteger foodPercentage = new InputInteger(f, Message.reqPercentage());
	    f.parse();
	    alimentosAux.add(foodKey.value());
	    percentagensAux.add(foodPercentage.value());
	    percentagemTotal += foodPercentage.value();
	} while (percentagemTotal < 100);

	if(percentagemTotal > 100)
	    throw new PercentageTooHighException(percentagemTotal);

	for(String nome : alimentosAux) {

	    alimentos.add(entity().getAlimento(nome));
	    percentagens.add(percentagensAux.get(alimentosAux.indexOf(nome)));
	} 
	
	for(Alimento a : alimentos) {
	    if(a.veg())
		tipo = Message.typeVeg();
	    else {
		tipo = Message.typeNoVeg();
		break;
	    }
	}
	
	entity().adicionaAlimento(new AlimentoAgregado(entity(),foodName.value(), tipo, alimentos, percentagens));
    }  
}
