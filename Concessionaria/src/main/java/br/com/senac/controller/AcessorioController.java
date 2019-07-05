package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Acessorio;
import br.com.senac.service.AcessorioService;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController {
	
	@Autowired
	AcessorioService acessorioService;
	
	@GetMapping("/listar")
	public ModelAndView listaAcessorio() {
		ModelAndView mv = new ModelAndView("acessorio/listar");
		mv.addObject("acessorio", acessorioService.listarAcessorios());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Acessorio acessorio) {
		ModelAndView mv = new ModelAndView("acessorio/adicionar");
		mv.addObject("acessorio", new Acessorio());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Acessorio acessorio) {
		acessorioService.cadastrar(acessorio);
		return listaAcessorio();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		acessorioService.excluir(id);
		return listaAcessorio();
	}
	
	@GetMapping("/altera/{id}")
	public ModelAndView alterar(@PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView("acessorio/alterar");
		mv.addObject("acessorio", acessorioService.buscar(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Acessorio acessorio) {
		acessorioService.alterar(acessorio);
		return listaAcessorio();
	}
}
