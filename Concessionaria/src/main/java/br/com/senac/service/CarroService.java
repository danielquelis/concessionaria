package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Carro;
import br.com.senac.repositorio.CarroRepositorio;
import br.com.senac.service.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	CarroRepositorio repoCarro;

	public Carro cadastrar(Carro carro) {
		carro.setId(null);
		return repoCarro.save(carro);
	}
	
	public Carro buscar(Integer id) throws ObjectNotFoundException{
		Optional<Carro> objCarro = repoCarro.findById(id);
		return objCarro.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado! id: " + id + ", Tipo: " + Carro.class.getName()));
	}
	
	public Carro alterar(Carro objCarro) throws ObjectNotFoundException{
		Carro objCarroEncontrado = buscar(objCarro.getId());
		objCarroEncontrado.setNome(objCarro.getNome());
		objCarroEncontrado.setPreco(objCarro.getPreco());
		objCarroEncontrado.setAno(objCarro.getAno());
		objCarroEncontrado.setFabricante(objCarro.getFabricante());
		objCarroEncontrado.setChave(objCarro.getChave());
		objCarroEncontrado.setDocumento(objCarro.getDocumento());
		objCarroEncontrado.setAcessorios(objCarro.getAcessorios());
		
		return repoCarro.save(objCarroEncontrado);
	}
	
	public void excluir(Integer id) {
		repoCarro.deleteById(id);
	}
	
	public List<Carro> listarCarros(){
		return repoCarro.findAll();
	}
}
