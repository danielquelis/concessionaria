package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Carro;
import br.com.senac.dominio.Chave;
import br.com.senac.service.ChaveService;

@Controller
@RequestMapping("/chave")
public class ChaveController {
	
	@Autowired
	ChaveService chaveService;
	
	@GetMapping("/listar")
	public ModelAndView listaChave() {
		ModelAndView mv = new ModelAndView("chave/listar");
		mv.addObject("chave", chaveService.listarChaves());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Chave chave) {
		ModelAndView mv = new ModelAndView("chave/adicionar");
		mv.addObject("chave", new Chave());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Chave chave) {
		chaveService.cadastrar(chave);
		return listaChave();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		chaveService.excluir(id);
		return listaChave();
	}
	
	@GetMapping("/altera/{id}")
	public ModelAndView alterar(@PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView("chave/alterar");
		mv.addObject("chave", chaveService.buscar(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Chave chave) {
		chaveService.alterar(chave);
		return listaChave();
	}

}
