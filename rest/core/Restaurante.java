package rest.core;

import java.io.*;

import java.util.List;
import java.util.ArrayList;

import rest.core.alimento.AlimentoSimples;

/**
   @author Telma Fernandes, 70490
   @author Tiago Fernandes, 70635
   @author Francisco Pedreira, 71033   

   @version 0.1
   
   A classe Restaurante e a classe onde e criado um restaurante, que ira conter pratos do dia. 
   @see rest.core.GestorOutlet
   @see rest.core.PratoDoDia   
*/

public class Restaurante implements Serializable {

    /**
       O atributo _outlet corresponde a um GestorOutlet
       O atributo _nome irá guardar o nome do restaurante criado
       O atributo _email irá guardar o email do restaurante criado
       O atributo _pratosDoDia írá guardar uma lista de pratos do dia
       O atributo _nrPratosDiaVendidos irá guardar o numero de pratos do dia vendidos
       O atributo _dinheiroAcumulado irá guardar o dinheiro total acumulado
    */
	
    private GestorOutlet _outlet;
    private String _nome;
    private String _email;
    private List<PratoDoDia> _pratosDoDia;
    private int _nrPratosDiaVendidos;
    private int _dinheiroAcumulado;

    /**
       O construtor da classe Restaurante vai criar um Restaurante e inicializar os atributos correspondentes
       @param outlet O outlet em que vai ser criado o restaurante
       @param nome O nome a dar ao restaurante
       @param email O email a dar ao restaurante
    */

    public Restaurante(GestorOutlet outlet, String nome, String email){
	_outlet = outlet;
	_nome = nome;
	_email = email;
	_nrPratosDiaVendidos = 0;
	_dinheiroAcumulado = 0;	
	_pratosDoDia = new ArrayList<PratoDoDia>();
    }

    /**
       O metodo compra permite comprar um prato do dia com uma ou mais doses, 
       actualizando o atributo que incrementa o numero de pratos do dia que o Cliente comprou 
       e também actualiza o valor monetário que já gastou com as encomendas
       @param pdd Prato do dia
       @param doses numero de doses
    */

    public void compra(PratoDoDia pdd, int doses) {
	double compraActual=0;
	_nrPratosDiaVendidos += doses;
	double precoDesconto = (pdd.getDesconto() * pdd.getPreco())/100;
	compraActual += pdd.getPreco() - precoDesconto;
	compraActual*=doses;
	_dinheiroAcumulado += compraActual;
	pdd.setQuantidade(doses);	
    }
 
    /**
       O metodo setDesconto permite aplicar um desconto a um dado alimento
       @param alimento Alimento
       @param desconto valor de desconto a aplicar
    */

    public void setDesconto(Alimento alimento, int desconto) {
	for(PratoDoDia pdd : getDishOfTheDay())
	    if(pdd.getAlimento().getName().equals(alimento.getName()))
		pdd.setDesconto(desconto);
    }	

    /**
       O metodo getCalculatedCalories devolve as calorias de um prato
       @param prato Prato do dia sobre o qual serao calculadas as calorias
       @return String devolve o nome do prato e as repescetivas calorias
    */

    public String getCalculatedCalories(String prato) {
	double calorias = 0;
	String nomePrato = new String();
	for(PratoDoDia pdd : getDishOfTheDay()) 
	    if(prato.equals(pdd.getAlimento().getName())) {
		nomePrato = pdd.getAlimento().getName(); 
		calorias = (pdd.getQuantidade() * pdd.getAlimento().getCalories());
		break;
	    }
		    
	return nomePrato + "|" + (int) calorias;
    }
    
    /**
       O metodo adicionaAoOutlet adiciona um prato do dia ao Outlet,
       caso este exista
       @param pratoDia Prato que ira ser adicionado ao Outlet
       @return boolean Devolve true caso o alimento ja esteja no outlet,
       caso contrario, coloca o alimento no outlet e devolve true
       Se nao encontrar o alimento pretendido no Outlet, devolve false
    */

    public boolean adicionaAoOutlet(String pratoDia){
	for(PratoDoDia e: getDishOfTheDay()){
	    if(pratoDia.equals(e.getAlimento().getName())){
		if(getOutlet().getDishOfTheDay().contains(e))
		    return true;
		else{
		    e.setAvailable();
		    getOutlet().adicionaPratoDoDia(e);
		    return true;
		}
			
	    }
		
	}
	return false;
    }

    /**
       O metodo pratoDisponivel verifica a existencia de um prato no Outlet
       @param nome Nome do prato do dia
       @return boolean Devolve true se o prato existe e falso caso contrario.
    */

    public boolean pratoDisponivel(String nome) {
	boolean existe = false;
	for(PratoDoDia prato : getOutlet().getDishOfTheDay())
	    if(nome.equals(prato.getAlimento().getName()))
		existe = true;
	    else
		existe = false;
	return existe;
    }

    /**
       O metodo retiraDoOutlet retira um prato do Outlet,
       caso este prato exista.
       @param pratoDia Prato do dia
       @return boolean Devolve true se o prato nao estiver disponivel no Outlet ou se retirar o prato do Outlet,
       caso contrario devolve false
    */

    public boolean retiraDoOutlet(String pratoDia){
	for(PratoDoDia f: getDishOfTheDay()){
	    if(pratoDia.equals(f.getAlimento().getName())){
		if(! (getOutlet().getDishOfTheDay().contains(f)) )
		    return true;
		else{
		    f.setUnavailable();
		    getOutlet().removePratoDoDia(f);
		    return true;
		}		
	    }		
	}
	return false;
    }

    /**
       O metodo getOutlet devolve um Outlet;
       @return _outlet Devolve um Outlet 
    */

    public GestorOutlet getOutlet() {
	return _outlet;
    }

    /**
       O metodo getName vai devolver o nome do restaurante
       @return String devolve o nome do restaurante
    */
    
    public String getName(){
	return _nome;
    }

    /**
       O metodo getMail vai devolver o email do restaurante
       @return String devolve o email do restaurante
    */
	
    public String getMail(){
	return _email;
    }

    /**
       O metodo getNrPratos vai devolver o numero de pratos do restaurante
       @return int devolve o numero de pratos do restaurante
    */
	
    public int getNrPratos(){
	return _nrPratosDiaVendidos;
    }
	
    /**
       O metodo getDinheiroAcumulado vai devolver o dinheiro acumulado do restaurante
       @return int devolve o dinheiro acumulado do restaurante
    */

    public int getDinheiroAcumulado(){
	return _dinheiroAcumulado;
    }

    /**
       O metodo getDishOfTheDay vai devolver a lista de pratos do dia do restaurante
       @return List<PratoDoDia> devolve a lista de pratos do dia do restaurante
    */

    public List<PratoDoDia> getDishOfTheDay(){
	return _pratosDoDia;
    }

    /**
       O metodo getAlimentos vai devolver a lista de alimentos do GestorOutlet
       @return List<Alimento> devolve a lista de alimentos do GestorOutlet
    */

    public List<Alimento> getAlimentos(){
	return _outlet.getFood();
    }

    /**
       O metodo getDish devolve um prato do dia, consoante o seu nome, de um determinado restaurante
       @param String nome do prato
       @return PratoDoDia devolve o prato do dia com o mesmo nome naquele restaurante
    */

    public PratoDoDia getDish(String nome) {
	PratoDoDia pddAux = null;
	for(PratoDoDia pratoDia : _pratosDoDia) {
	    if(pratoDia.getAlimento().getName().equals(nome)){
		pddAux = pratoDia;
		break;	
	    }
	}
	return pddAux;
    }

    /**
       O metodo adicionaPratoDoDia vai adicionar um prato do dia a lista de pratos do dia do restaurante
       @param prato Prato do dia
    */

    public void adicionaPratoDoDia(PratoDoDia prato){
	_pratosDoDia.add(prato);
    }
	
    /**
       O metodo toString imprime para o terminal o nome, numero de pratos e dinheiro acumulado do restaurante, respectivamente.
       @return String
    */

    @Override
	public String toString() {
	return getName() + "|" + getNrPratos() + "|" + _dinheiroAcumulado;
    }	
	
}
