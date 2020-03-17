package br.com.cotefacil.gerenciador.modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
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
		
		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");

	    Usuario u2 = new Usuario();
	    u2.setLogin("ana");
	    u2.setSenha("12345");

	    listaUsuarios.add(u1);
	    listaUsuarios.add(u2);
		
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
	
	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usu : listaUsuarios) {
			if (usu.ehIgual(login, senha)) {
				return usu;
			}
		}
		return null;
	}
	
	

}
