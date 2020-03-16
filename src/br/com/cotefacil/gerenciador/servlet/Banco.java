package br.com.cotefacil.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private	static Integer chaveSequencial = 1;
	
	static {
		
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
		
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
	
	public void removeEmpresa(Integer id) {
		
		if (id == 0) return;
		
		Iterator<Empresa> it = lista.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = (Empresa) it.next();
			
			if (empresa.getId() == id) {
				it.remove();
			}
			
		}
		
	}
	
	

}
