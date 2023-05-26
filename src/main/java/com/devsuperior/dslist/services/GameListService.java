package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

// camada responsável pela lógica/regra de negócio

@Service // ou @component para registrar como sendo um componente da aplicação pro spring poder gerenciar
public class GameListService {

	//injetar um gameRepository no gameService
	@Autowired
	private GameListRepository gameListRepository; //puxando uma instancia do gameRepository para dentro do gameService
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
		// respeiando a arquitetura,onde o service tem que retornar DTO
	}
	
	
	
}
