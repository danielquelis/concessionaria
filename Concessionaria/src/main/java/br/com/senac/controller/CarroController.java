package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Carro;
import br.com.senac.service.AcessorioService;
import br.com.senac.service.CarroService;
import br.com.senac.service.ChaveService;
import br.com.senac.service.DocumentoService;
import br.com.senac.service.FabricanteService;
import br.com.senac.service.ObjectNotFoundException;

@Controller
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroService carroService;
	
	@Autowired
	DocumentoService docService;
	
	@Autowired
	ChaveService chaveService;
	
	@Autowired
	AcessorioService acessorioService;
	
	@Autowired
	FabricanteService fabricanteService;
	
	@GetMapping("/listar")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("carro/listar");
		mv.addObject("carros", carroService.listarCarros());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("carro/adicionar");
		mv.addObject("carro", new Carro());
		mv.addObject("documento", docService.listarDocumentos());
		mv.addObject("chave", chaveService.listarChaves());
		mv.addObject("acessorio", acessorioService.listarAcessorios());
		mv.addObject("fabricante", fabricanteService.listarFabricantes());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Carro carro) {
		carroService.cadastrar(carro);
		return listaCarros();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		carroService.excluir(id);
		return listaCarros();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("carro/alterar");
		mv.addObject("carro", carroService.buscar(id));
		mv.addObject("documento", docService.listarDocumentos());
		mv.addObject("chave", chaveService.listarChaves());
		mv.addObject("acessorio", acessorioService.listarAcessorios());
		mv.addObject("fabricante", fabricanteService.listarFabricantes());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Carro carro) throws ObjectNotFoundException{
		carroService.alterar(carro);
		return listaCarros();
	}
}
