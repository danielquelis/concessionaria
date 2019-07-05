package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Fabricante;
import br.com.senac.repositorio.FabricanteRepositorio;

@Service
public class FabricanteService {
	
	@Autowired
	FabricanteRepositorio repoFabricante;
	
	public Fabricante cadastrar(Fabricante fabricante) {
		fabricante.setId(null);
		return repoFabricante.save(fabricante);
	}
	
	public Fabricante buscar(Integer id) throws ObjectNotFoundException{
		Optional<Fabricante> objFabricante = repoFabricante.findById(id);
		return objFabricante.orElseThrow(() -> new ObjectNotFoundException("Fabricante não encontrado! id: " + id + ", Tipo: " + Fabricante.class.getName()));
	}
	
	public Fabricante alterar(Fabricante objFabricante) throws ObjectNotFoundException{
		Fabricante objFabricanteEncontrado = buscar(objFabricante.getId());
		objFabricanteEncontrado.setNome(objFabricante.getNome());		
		return repoFabricante.save(objFabricanteEncontrado);
	}
	
	public void excluir(Integer id) {
		repoFabricante.deleteById(id);
	}
	
	public List<Fabricante> listarFabricantes(){
		return repoFabricante.findAll();
	}
}
