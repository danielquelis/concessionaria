package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Chave;
import br.com.senac.repositorio.ChaveRepositorio;

@Service
public class ChaveService {
	
	@Autowired
	ChaveRepositorio repoChave;
	
	public Chave cadastrar(Chave chave) {
		chave.setId(null);
		return repoChave.save(chave);
	}
	
	public Chave buscar(Integer id) throws ObjectNotFoundException{
		Optional<Chave> objChave = repoChave.findById(id);
		return objChave.orElseThrow(() -> new ObjectNotFoundException("Chave não encontrado! id: " + id + ", Tipo: " + Chave.class.getName()));
	}
	
	public Chave alterar(Chave objChave) throws ObjectNotFoundException{
		Chave objChaveEncontrado = buscar(objChave.getId());
		objChaveEncontrado.setCodigo(objChave.getCodigo());		
		return repoChave.save(objChaveEncontrado);
	}
	
	public void excluir(Integer id) {
		repoChave.deleteById(id);
	}
	
	public List<Chave> listarChaves(){
		return repoChave.findAll();
	}
}
