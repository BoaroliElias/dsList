package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//classe criada para representar uma chave primária múltipla. Como o belonging 
// tinha duas pk, que era a pk das duas tabelas que estavam relacionadas a ela,
//e não posso colocar dois tipos de dados no parâmetro do GameRepository, em:
// extends JpaRepository<Game, Long>, só posso passar dois parâmetros, um do tipo
// game, e outro do tipo Long (que é o ID),eu crio essa CLASSE AUXILIAR e chamo ela dentro
// da classe Belonging. Ou seja, o tipo de dados da PK em belonging vai ser do tipo BelongingPK,
// que possui dois atributos como PK.


@Embeddable // encapsulando dois atributos em um só nessa classe
public class BelongingPK {
	
	// config para fazer o mapeamento Objeto relacional
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
		
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	//comparação de objetos usando as duas pk's
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
	
	

}
