package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Documento;
import br.com.senac.repositorio.DocumentoRepositorio;

@Service
public class DocumentoService {
	
	@Autowired
	DocumentoRepositorio repoDocumento;
	
	public Documento cadastrar(Documento documento) {
		documento.setId(null);
		return repoDocumento.save(documento);
	}
	
	public Documento buscar(Integer id) throws ObjectNotFoundException{
		Optional<Documento> objDocumento = repoDocumento.findById(id);
		return objDocumento.orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado! id: " + id + ", Tipo: " + Documento.class.getName()));
	}
	
	public Documento alterar(Documento objDocumento) throws ObjectNotFoundException{
		Documento objDocumentoEncontrado = buscar(objDocumento.getId());
		objDocumentoEncontrado.setRenavam(objDocumento.getRenavam());		
		return repoDocumento.save(objDocumentoEncontrado);
	}
	
	public void excluir(Integer id) {
		repoDocumento.deleteById(id);
	}
	
	public List<Documento> listarDocumentos(){
		return repoDocumento.findAll();
	}
}
