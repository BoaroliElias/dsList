package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

// camada responsável pela lógica/regra de negócio

@Service // ou @component para registrar como sendo um componente da aplicação pro spring poder gerenciar
public class GameService {

	//injetar um gameRepository no gameService
	@Autowired
	private GameRepository gameRepository; //puxando uma instancia do gameRepository para dentro do gameService
	
	public List<GameMinDto> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
		return dto;
		// respeiando a arquitetura,onde o service tem que retornar DTO
	}
	
	
	
}
