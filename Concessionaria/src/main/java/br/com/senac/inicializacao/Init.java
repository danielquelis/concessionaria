package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Acessorio;
import br.com.senac.dominio.Carro;
import br.com.senac.dominio.Chave;
import br.com.senac.dominio.Documento;
import br.com.senac.dominio.Fabricante;
import br.com.senac.repositorio.AcessorioRepositorio;
import br.com.senac.repositorio.CarroRepositorio;
import br.com.senac.repositorio.ChaveRepositorio;
import br.com.senac.repositorio.DocumentoRepositorio;
import br.com.senac.repositorio.FabricanteRepositorio;
//import br.com.senac.service.CarroService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	CarroRepositorio repoCarro;
	
	@Autowired
	ChaveRepositorio repoChave;

	@Autowired
	FabricanteRepositorio repoFabricante;
	
	@Autowired
	AcessorioRepositorio repoAcessorio;
	
	@Autowired
	DocumentoRepositorio repoDocumento;
	
	//	@Autowired
	//	CarroService serviceCarro;
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Chave chave1 = new Chave();
		chave1.setCodigo(123);
		
		Chave chave2 = new Chave();
		chave2.setCodigo(456);
		
		Chave chave3 = new Chave();
		chave3.setCodigo(789);
		
		Documento doc1 = new Documento();
		doc1.setRenavam("0123456789");
		doc1.setPlaca("ABC-1234");
		doc1.setAno("2015");
		
		Documento doc2 = new Documento();
		doc2.setRenavam("0123456789");
		doc2.setPlaca("DEF-4321");
		doc2.setAno("2018");
		
		Documento doc3 = new Documento();
		doc3.setRenavam("0123456789");
		doc3.setPlaca("GHI-5678");
		doc3.setAno("2019");
				
		Fabricante fab1 = new Fabricante();
		fab1.setNome("VolksWagen");
		
		Fabricante fab2 = new Fabricante();
		fab2.setNome("Jeep");
		
		Fabricante fab3 = new Fabricante();
		fab3.setNome("Land Rover");
		
		Carro carro1 = new Carro();
		carro1.setNome("Fox");
		carro1.setAno(2018);
		carro1.setPreco(60000);
		carro1.setChave(chave1);
		carro1.setFabricante(fab1);
		carro1.setDocumento(doc1);
		
		Carro carro2 = new Carro();
		carro2.setNome("Renegade");
		carro2.setAno(2019);
		carro2.setPreco(120000);
		carro2.setChave(chave2);
		carro2.setFabricante(fab2);
		carro2.setDocumento(doc2);
		
		Carro carro3 = new Carro();
		carro3.setNome("Range Rover");
		carro3.setAno(2019);
		carro3.setPreco(250000);
		carro3.setChave(chave3);
		carro3.setFabricante(fab3);
		carro3.setDocumento(doc3);
		
		Acessorio acc1 = new Acessorio();
		acc1.setDescricao("Ar Condicionado");
		
		Acessorio acc2 = new Acessorio();
		acc2.setDescricao("Direção Hidráulica");

		Acessorio acc3 = new Acessorio();
		acc3.setDescricao("Vidro Elétrico");
		
		repoDocumento.saveAll(Arrays.asList(doc1, doc2, doc3));
		repoFabricante.saveAll(Arrays.asList(fab1, fab2, fab3));
		repoChave.saveAll(Arrays.asList(chave1, chave2, chave3));
		repoAcessorio.saveAll(Arrays.asList(acc1, acc2, acc3));
		
		carro1.setAcessorios(Arrays.asList(acc1, acc2, acc3));
		carro2.setAcessorios(Arrays.asList(acc1, acc2, acc3));
		carro3.setAcessorios(Arrays.asList(acc1, acc2, acc3));
		
		repoCarro.saveAll(Arrays.asList(carro1, carro2, carro3));
	}

}
