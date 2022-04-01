package com.github.souzaak.colaboradores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.souzaak.colaboradores.model.Empregador;
import com.github.souzaak.colaboradores.repository.EmpregadorRepository;

@Service
public class EmpregadorService {
	
	@Autowired
	private EmpregadorRepository empregadorRepository;
	
	public List<Empregador> buscarTodos(){
		return empregadorRepository.findAll();
	}
	
	public Empregador buscarPorId(Integer id) {
		Optional<Empregador> opt = empregadorRepository.findById(id);
		if(opt.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregador n\u00E3o encontrado!");
		}
		return opt.get();
	}

	public Empregador criar(Empregador empregador) {
		empregador.setId(null);
		return empregadorRepository.save(empregador);
	}

	public void removerPorId(Integer id) {
		empregadorRepository.deleteById(id);
	}

	public Empregador atualizarTudoPorId(Integer id, Empregador empregador) {
		buscarPorId(id);
		empregador.setId(id);
		return empregadorRepository.save(empregador);
	}

	public Empregador atualizarParcialPorId(Integer id, Empregador empregador) {
		Empregador empregadorSalvo = buscarPorId(id);
		empregador.setId(id);
		if(empregador.getNome() != null) {
			empregadorSalvo.setNome(empregador.getNome());
		}
		if(empregador.getIdentificador() != null) {
			empregadorSalvo.setIdentificador(empregador.getIdentificador());
		}
		return empregadorRepository.save(empregadorSalvo);
	}

}
