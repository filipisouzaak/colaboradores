package com.github.souzaak.colaboradores.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.souzaak.colaboradores.model.Colaborador;
import com.github.souzaak.colaboradores.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorResource {
	
	@Autowired //Injeção de dependência
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public List<Colaborador> buscarTodos(){
		return colaboradorService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Colaborador buscarPorId(@PathVariable Integer id) {
		return colaboradorService.buscarPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador criar(@RequestBody Colaborador colaborador) {
		return colaboradorService.criar(colaborador);
	}
	
	@DeleteMapping("/{id}")
	public void removerPorId(@PathVariable Integer id) {
		colaboradorService.removerPorId(id);
	}
	
	@PutMapping("/{id}")
	public Colaborador atualizarTudoPorId(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
		return colaboradorService.atualizarTudoPorId(id, colaborador);
	}
	
	@PatchMapping("/{id}") //Aqui, com o PATCH, pode-se fazer a atualização PARCIAL
	public Colaborador atualizarParcialPorId(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
		return colaboradorService.atualizarParcialPorId(id, colaborador);
	}
}
