package com.github.souzaak.colaboradores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.souzaak.colaboradores.model.Colaborador;
import com.github.souzaak.colaboradores.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public List<Colaborador> buscarTodos(){
		return colaboradorRepository.findAll();
	}

	public Colaborador buscarPorId(Integer id) {
		Optional<Colaborador> opt = colaboradorRepository.findById(id);
		if(opt.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador n\u00E3o encontrado!");
		}
		return opt.get();
	}

	public Colaborador criar(Colaborador colaborador) {
		colaborador.setId(null);
		return colaboradorRepository.save(colaborador);
	}

	public void removerPorId(Integer id) {
		colaboradorRepository.deleteById(id);
	}

	public Colaborador atualizarTudoPorId(Integer id, Colaborador colaborador) {
		buscarPorId(id);
		colaborador.setId(id);
		return colaboradorRepository.save(colaborador);
	}

	public Colaborador atualizarParcialPorId(Integer id, Colaborador colaborador) {
		Colaborador colaboradorSalvo = buscarPorId(id);
		colaborador.setId(id);
		if(colaborador.getNome() != null) {
			colaboradorSalvo.setNome(colaborador.getNome());
		}
		if(colaborador.getSobrenome() != null) {
			colaboradorSalvo.setSobrenome(colaborador.getSobrenome());
		}
		return colaboradorRepository.save(colaboradorSalvo);
	}
}
