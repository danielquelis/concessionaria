package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Carro;
import br.com.senac.dominio.Documento;
import br.com.senac.service.DocumentoService;

@Controller
@RequestMapping("/documento")
public class DocumentoController {
	
	@Autowired
	DocumentoService documentoService;
	
	@GetMapping("/listar")
	public ModelAndView listaDocumento() {
		ModelAndView mv = new ModelAndView("documento/listar");
		mv.addObject("documento", documentoService.listarDocumentos());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Documento documento) {
		ModelAndView mv = new ModelAndView("documento/adicionar");
		mv.addObject("documento", new Documento());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Documento documento) {
		documentoService.cadastrar(documento);
		return listaDocumento();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		documentoService.excluir(id);
		return listaDocumento();
	}
	
	@GetMapping("/altera/{id}")
	public ModelAndView alterar(@PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView("documento/alterar");
		mv.addObject("documento", documentoService.buscar(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Documento documento) {
		documentoService.alterar(documento);
		return listaDocumento();
	}
}
