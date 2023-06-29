package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

// camada responsável pela lógica/regra de negócio

@Service // ou @component para registrar como sendo um componente da aplicação pro spring poder gerenciar
public class GameService {

	//injetar um gameRepository no gameService
	@Autowired
	private GameRepository gameRepository; //puxando uma instancia do gameRepository para dentro do gameService
	
	// boa prática para colocar nos métodos do service para que seja um método transacional com banco de dados
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDto(x)).toList();
		// respeiando a arquitetura,onde o service tem que retornar DTO
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDto(x)).toList();
		// respeiando a arquitetura,onde o service tem que retornar DTO
	}
	
	
	
	
}
