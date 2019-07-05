package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Acessorio;
import br.com.senac.repositorio.AcessorioRepositorio;

@Service
public class AcessorioService {
	
	@Autowired
	AcessorioRepositorio repoAcessorio;
	
	public Acessorio cadastrar(Acessorio acessorio) {
		acessorio.setId(null);
		return repoAcessorio.save(acessorio);
	}
	
	public Acessorio buscar(Integer id) throws ObjectNotFoundException{
		Optional<Acessorio> objAcessorio = repoAcessorio.findById(id);
		return objAcessorio.orElseThrow(() -> new ObjectNotFoundException("Acessorio não encontrado! id: " + id + ", Tipo: " + Acessorio.class.getName()));
	}
	
	public Acessorio alterar(Acessorio objAcessorio) throws ObjectNotFoundException{
		Acessorio objAcessorioEncontrado = buscar(objAcessorio.getId());
		objAcessorioEncontrado.setDescricao(objAcessorio.getDescricao());		
		return repoAcessorio.save(objAcessorioEncontrado);
	}
	
	public void excluir(Integer id) {
		repoAcessorio.deleteById(id);
	}
	
	public List<Acessorio> listarAcessorios(){
		return repoAcessorio.findAll();
	}

}
