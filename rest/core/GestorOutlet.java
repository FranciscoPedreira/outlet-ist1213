package rest.core;

import java.util.*;

import java.io.*;

import rest.textui.clients.Message;

import rest.core.alimento.*;

public class GestorOutlet implements Serializable, Observer{

    //Atributo

    private List<Alimento> _alimentos;
    private List<PratoDoDia> _pratosDoDia;
    private List<Cliente> _clientes;
    private List<Restaurante> _restaurantes;
    private List<Cliente> _listaAlertaNovidade;
    private List<Cliente> _listaAlertaReducao;
    private String _nomeDoFicheiro;
    private boolean _alteracao; 
	
    //Construtor
    
    public GestorOutlet() {
	_alimentos = new ArrayList<Alimento>();
	_pratosDoDia = new ArrayList<PratoDoDia>();
	_clientes = new ArrayList<Cliente>();
	_restaurantes = new ArrayList<Restaurante>();
	_listaAlertaNovidade = new ArrayList<Cliente>();
	_listaAlertaReducao = new ArrayList<Cliente>();
	_nomeDoFicheiro = "";
	_alteracao = false;
    }

    //Alerta

    public void enviaAlertaDesconto(PratoDoDia pdd) {
	for(Cliente c : getListaReducao()) 
	    if((c.getTipo().getVeg() && pdd.getAlimento().veg()) || !c.getTipo().getVeg())
		c.recebeAlerta(new Alerta(Message.alertDiscount(pdd.getAlimento().getName()), Message.alertTypeDiscount()));
    }
    
    public void enviaAlertaNovidade(PratoDoDia pdd) {
	for(Cliente c : getListaNovidade()) 
	    if((c.getTipo().getVeg() && pdd.getAlimento().veg()) || !c.getTipo().getVeg())
		c.recebeAlerta(new Alerta(Message.alertNovelty(pdd.getAlimento().getName()),Message.alertTypeNovelty()));
    }
    
    //Adiciona

    public void adicionaListaNovidade(Cliente cliente) {
	_listaAlertaNovidade.add(cliente);
	setAlteracao(true);
    }

    public void adicionaListaReducao(Cliente cliente) {
	_listaAlertaReducao.add(cliente);
	setAlteracao(true);
    }

    //Remove

    public void removeListaNovidade(Cliente cliente) {
	_listaAlertaNovidade.remove(cliente);
    }

    public void removeListaReducao(Cliente cliente) {
	_listaAlertaReducao.remove(cliente);
    }

    //Show
    
    public String showRestaurantes(Restaurante restaurante, String nome) {
	double precoDesconto = ((restaurante.getDish(nome).getPreco() * restaurante.getDish(nome).getDesconto())/100);
	return restaurante.getName() + "|" + (int)(restaurante.getDish(nome).getPreco() - precoDesconto)+ "|" + restaurante.getDish(nome).getQuantidade();
    }

    //Get
    
    public List<Cliente> getClientesSemAlertas(){
	List<Cliente> clientesSemAlertas = new ArrayList<Cliente>();
	for(Cliente cliente : getClientes())
	    if(cliente.getInbox().size() == 0)
		clientesSemAlertas.add(cliente);
	return clientesSemAlertas;
    }

    
    public List<Cliente> getClientesComEncom(){
	List<Cliente> clientesComEncom = new ArrayList<Cliente>();
	for(Cliente cliente : getClientes())
	    if(cliente.getOrders() > 0)
		clientesComEncom.add(cliente);
	return clientesComEncom;
    }

    public List<Cliente> getListaReducao() {
	return _listaAlertaReducao;
    }
    
    public List<Cliente> getListaNovidade() {
	return _listaAlertaNovidade;
    }

    public List<Alimento> getVeg() {
	ArrayList<Alimento> alimentosVeg = new ArrayList<Alimento>();
	for(Alimento f : this.getFood()){
	    if(f.veg())
		alimentosVeg.add(f);
	}
	return alimentosVeg;
    }

    public List<Restaurante> getRestComDesc(){
	int desconto = 0;
	ArrayList<Restaurante> restComDesconto = new ArrayList<Restaurante>();
	for(Restaurante g : this.getRestaurants()){
	    for(PratoDoDia h : g.getDishOfTheDay()){
		if(h.getDesconto() > desconto)
		    desconto = h.getDesconto();
	    } if(desconto > 0){
		restComDesconto.add(g);
		desconto = 0;
	    }
	} return restComDesconto;
    }

    public List<Restaurante> getRestaurantesComPrato(String nome) {
	List<Restaurante> restaurantes = new ArrayList<Restaurante>();
	for(Restaurante r : getRestaurants())
	    for(PratoDoDia pdd : r.getDishOfTheDay())
		if(pdd.getAlimento().getName().equals(nome))
		    restaurantes.add(r);

	return restaurantes;
    }
    
    public Cliente getCliente(String email) {
	for(Cliente c : _clientes) {
	    if(c.getEmail().equals(email))
		return c;
	}
	return null;
    }

    public Alimento getAlimento(String nome) {
	for(Alimento a : _alimentos) {
	    if(a.getName().equals(nome))
		return a;
	}
	return null;
    }
    
    public List<Restaurante> getRestaurants() {
	return _restaurantes;
    }

    public List<Alimento> getFood() {
	return _alimentos;
    }

    public List<PratoDoDia> getDishOfTheDay(){
	return _pratosDoDia;
    }

    public String getNomeDoFicheiro() {
	return _nomeDoFicheiro;
    }

    public boolean getAlteracao() {
	return _alteracao;
    }
     
    public List<Cliente> getClientes() {
	return _clientes;
    }

    //Set

    public void setNomeDoFicheiro(String nomeDoFicheiro) {
	_nomeDoFicheiro = nomeDoFicheiro;
    }

    public void setAlteracao(boolean alteracao) {
	_alteracao = alteracao;
    }

    //Adiciona

    public void adicionaAlimento(Alimento alimento){
	_alimentos.add(alimento);
	setAlteracao(true);
    }

    public void adicionaPratoDoDia(PratoDoDia pratoDoDia){
	_pratosDoDia.add(pratoDoDia);
	setAlteracao(true);	
	enviaAlertaNovidade(pratoDoDia);
    }

    public void adicionaCliente(Cliente cliente){
	_clientes.add(cliente);
	setAlteracao(true);
    }

    public void adicionaRestaurante(Restaurante restaurante){
	_restaurantes.add(restaurante);
	setAlteracao(true);
    }

    //Remove

    public void removePratoDoDia(PratoDoDia pratoDoDia){
	_pratosDoDia.remove(pratoDoDia);
	setAlteracao(true);
    }

    //Existe

    public boolean existeCliente(String email) {
	for(Cliente c : _clientes) {
	    if(c.getEmail().equals(email))
		return true;
	}
	return false;
    }
    
    public boolean existeAlimento(String nome) {
	for(Alimento a : _alimentos) {
	    if(a.getName().equals(nome))
		return true;
	}
	return false;
    }

    public boolean existePrato(String nome) {
	for(PratoDoDia p : _pratosDoDia) {
	    if(p.getAlimento().getName().equals(nome))
		return true;
	}
	return false;
    }

    //Update

    public void update(Observable obj, Object arg) {
	if(arg instanceof Alimento) {
	    for(Restaurante r : getRestaurants()) {
		for(PratoDoDia pdd : r.getDishOfTheDay()) {
		    if(pdd.getAlimento() instanceof AlimentoAgregado)
			((AlimentoAgregado)(pdd.getAlimento())).recalculaCalorias();
		}
	    }
	}

	else if(arg instanceof PratoDoDia) 
	    enviaAlertaDesconto((PratoDoDia) arg);
    }
    
    //Parse  

    public void parseInputFile(String file) {
	try {
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String s;

	    while((s = in.readLine())!= null) {
		String line = new String(s.getBytes(), "UTF-8");
		String[] split = line.split("\\|");

		if(split[0].equals("VEGET") || split[0].equals("OMNIV")) {
		    String nome = String.valueOf(split[1]);
		    String email = String.valueOf(split[2]);

		    if(split[0].equals("VEGET"))
			adicionaCliente(new Cliente(this, email, nome, Message.clientTypeVegetarian()));
		    else
			adicionaCliente(new Cliente(this, email, nome, Message.clientTypeOmnivorous()));
		}

		if(split[0].equals("RESTAURANT")) {
		    String nome = String.valueOf(split[1]);
		    String email = String.valueOf(split[2]);
		    adicionaRestaurante(new Restaurante(this, nome, email));
		}

		if(split[0].equals(rest.textui.food.Message.typeVegetable()) || split[0].equals(rest.textui.food.Message.typeFish()) || split[0].equals(rest.textui.food.Message.typeMeat())) {
		    String nome = String.valueOf(split[1]);
		    int calorias = Integer.valueOf(split[2]);
		    adicionaAlimento(new AlimentoSimples(this, split[0], nome, calorias));
		}
		
		if(split[0].equals("PREPARED")) {
		    List<Alimento> alimentos = new ArrayList<Alimento>();
		    List<Integer> percentagens = new ArrayList<Integer>();
		    String nome = String.valueOf(split[1]);
		    String tipo = new String();
		    int i = 2, percentagemTotal = 0;
		    do {
			String[] token = split[i].split("\\=");
			for(Alimento a : this.getFood()) {
			    if(a.getName().equals(token[0])) {
				alimentos.add(a);
				percentagens.add(Integer.parseInt(token[1]));
				percentagemTotal += Integer.parseInt(token[1]);
				i++;
				break;
			    }
			}
		    } while(percentagemTotal < 100);

		    for(Alimento a : alimentos) {
			if(a.veg())
			    tipo = rest.textui.food.Message.typeVeg();
			else {
			    tipo = rest.textui.food.Message.typeNoVeg();
			    break;
			}
		    }

		    adicionaAlimento(new AlimentoAgregado(this, nome, tipo, alimentos, percentagens));
		}
		    
		if(split[0].equals("DOTD")) {
		    String restaurante = String.valueOf(split[1]);
		    String nome = String.valueOf(split[2]);
		    int quantidade = Integer.valueOf(split[3]);
		    int preco = Integer.valueOf(split[4]);
		    int desconto = Integer.valueOf(split[5]);

		    for(Restaurante r : this.getRestaurants()) {
			if(r.getName().equals(restaurante)) {
			    for(Alimento a : this.getFood()) {
				if(a.getName().equals(nome)) {
				    r.adicionaPratoDoDia(new PratoDoDia(r,a,quantidade, preco, desconto));
				    break;
				}
			    }
			}
		    }
		}
	    }
	} catch(IOException e) {
	    System.err.println(rest.textui.manager.Message.fileNotFound(file));
	}
    }    
    

    //Desserialize
    
    public void abrir(String file) throws IOException, ClassNotFoundException{

	ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

	GestorOutlet outlet = (GestorOutlet)in.readObject();
	in.close();
	_nomeDoFicheiro = outlet.getNomeDoFicheiro();
	_alimentos = outlet.getFood();
	_pratosDoDia = outlet.getDishOfTheDay();
	_clientes = outlet.getClientes();
	_restaurantes = outlet.getRestaurants();	
    }

    //Serialize
    
    public void guardar(String file) throws IOException {
	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
	  
	out.writeObject(this);
	out.close();
    }

    //Reset
    
    public void reset(){
 	_alimentos.clear();
	_pratosDoDia.clear();
	_clientes.clear();
	_restaurantes.clear();
	_nomeDoFicheiro = "";
	_alteracao = false;
    } 
}

