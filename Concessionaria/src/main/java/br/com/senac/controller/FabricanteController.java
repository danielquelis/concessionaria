package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Carro;
import br.com.senac.dominio.Fabricante;
import br.com.senac.service.FabricanteService;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
	
	@Autowired
	FabricanteService fabricanteService;
	
	@GetMapping("/listar")
	public ModelAndView listaFabricante() {
		ModelAndView mv = new ModelAndView("fabricante/listar");
		mv.addObject("fabricante", fabricanteService.listarFabricantes());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Fabricante fabricante) {
		ModelAndView mv = new ModelAndView("fabricante/adicionar");
		mv.addObject("fabricante", new Fabricante());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Fabricante fabricante) {
		fabricanteService.cadastrar(fabricante);
		return listaFabricante();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		fabricanteService.excluir(id);
		return listaFabricante();
	}
	
	@GetMapping("/altera/{id}")
	public ModelAndView alterar(@PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView("fabricante/alterar");
		mv.addObject("fabricante", fabricanteService.buscar(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Fabricante fabricante) {
		fabricanteService.alterar(fabricante);
		return listaFabricante();
	}
}
