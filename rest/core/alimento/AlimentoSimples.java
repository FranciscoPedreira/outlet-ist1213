package rest.core.alimento;

import rest.core.Alimento;
import rest.core.GestorOutlet;

public class AlimentoSimples extends Alimento {

    //Construtor
    
    public AlimentoSimples(GestorOutlet outlet, String tipo, String nome, int calorias) {
	super(outlet, nome, tipo);
	_calorias = calorias;
    }
    
    //Set
    
    public void setCalories(int calorias) {
	_calorias = calorias;
	setChanged();
	notifyObservers(this);
    }
    
    //toString
    
    @Override
	public String toString() {
	return getType() + "|" + getName() + "|" + String.format("%.0f", getCalories());
    }
}
