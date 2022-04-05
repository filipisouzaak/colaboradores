package com.github.souzaak.colaboradores.resource;

import java.util.List;

import javax.validation.Valid;

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

import com.github.souzaak.colaboradores.model.Empregador;
import com.github.souzaak.colaboradores.service.EmpregadorService;

@RestController
@RequestMapping("/empregador")
public class EmpregadorResource {
	
	@Autowired
	private EmpregadorService empregadorService;
	
	@GetMapping
	public List<Empregador> buscarTodos(){
		return empregadorService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Empregador buscarPorId(@PathVariable Integer id) {
		return empregadorService.buscarPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empregador criar(@Valid @RequestBody Empregador empregador) {
		return empregadorService.criar(empregador);
	}
	
	@DeleteMapping("/{id}")
	public void removerPorId(@PathVariable Integer id) {
		empregadorService.removerPorId(id);
	}
	
	@PutMapping("/{id}")
	public Empregador atualizarTudoPorId(@PathVariable Integer id, @RequestBody Empregador empregador) {
		return empregadorService.atualizarTudoPorId(id, empregador);
	}
	
	@PatchMapping("/{id}")
	public Empregador atualizarParcialPorId(@PathVariable Integer id, @RequestBody Empregador empregador) {
		return empregadorService.atualizarParcialPorId(id, empregador);
	}
}
