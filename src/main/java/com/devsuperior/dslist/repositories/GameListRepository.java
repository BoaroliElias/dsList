package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

//interface de acesso ao banco de dados

// somente fazendo o extends da JpaRepository é possível acessar a camada do db
public interface GameListRepository extends JpaRepository<GameList, Long>{

	//atualiza a position da tabela tb_belonging, com a position vinda
	// por parâmetro de updateBelongingPosition. Para a lista e game vindos no parâemtro.
	
	//funcao que faz no banc de dados essa atualização: DADO O ID DA LISTA, E O ID DO GAME, IRÁ ATUALIZAR A POSIÇÃO
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging "
			+ "SET position = :newPosition "
			+ "WHERE list_id = :listId "
			+ "AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition); 
	
}
