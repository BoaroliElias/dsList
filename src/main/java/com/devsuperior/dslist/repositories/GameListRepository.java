package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

//interface de acesso ao banco de dados

// somente fazendo o extends da JpaRepository é possível acessar a camada do db
public interface GameListRepository extends JpaRepository<GameList, Long>{

	 
}
