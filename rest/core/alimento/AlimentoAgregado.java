package rest.core.alimento;

import pt.utl.ist.po.ui.Display;

import rest.core.GestorOutlet;
import rest.core.Alimento;

import java.util.List;
import java.util.ArrayList;

public class AlimentoAgregado extends Alimento {

    //Atributo
    
    private List<Alimento> _listaAlimentos = new ArrayList<Alimento>();
    private List<Integer> _percentagemAlimentos = new ArrayList<Integer>();
    
    //Construtor
    
    public AlimentoAgregado(GestorOutlet outlet, String nome, String tipo, List<Alimento> listaAlimentos, List<Integer> percentagemAlimentos) {
	super(outlet, nome, tipo);
	_listaAlimentos.addAll(listaAlimentos);
	_percentagemAlimentos.addAll(percentagemAlimentos);
	_calorias = 0;
	for(Alimento a : _listaAlimentos) {
	    _calorias += a.getCalories() * getPercentagem(a);
	}
	_calorias /= 100;
    }
     
    //Recalcular calorias

    public void recalculaCalorias() {
	boolean foodFound = false;
	for(Alimento a : _listaAlimentos) {
	    for(Alimento alimento : getOutlet().getFood()) {
		if(a.getName().equals(alimento.getName())) {
		    setAlimento(a, alimento);	
		    foodFound = true;
		}
	    }	        
	}
	if(foodFound)
	    this.novasCalorias();
    }
    
    public void novasCalorias() {
	_calorias = 0;
	for(Alimento a : _listaAlimentos) {
	    _calorias += a.getCalories() * getPercentagem(a);
	}
	_calorias /= 100;
    }
    
    //Descricao

    public List<String> getDescricao(List<String> descricao) {
	descricao.add(this.toString());
	for(Alimento a : _listaAlimentos) {
	    descricao.add(describe(a));
	    if(a instanceof AlimentoAgregado) {
		((AlimentoAgregado)a).getDescricao(descricao);
	    }	
	}
	return descricao;
    }

    public String describe(Alimento alimento) {
	return alimento.getType() + "|" + alimento.getName() + "|" + getPercentagem(alimento);
    }

    //Get

    public List<Alimento> getListaAlimentos() {
	return _listaAlimentos;
    }
    
    public int getPercentagem(Alimento alimento) {
	return _percentagemAlimentos.get(_listaAlimentos.indexOf(alimento));
    }

    //Set

    public void setAlimento(Alimento alimento, Alimento novoAlimento) {
	_listaAlimentos.set(_listaAlimentos.indexOf(alimento), novoAlimento);
    }

    //toString

    @Override
	public String toString() {
	return getType() + "|" + getName();
    }
    
}
