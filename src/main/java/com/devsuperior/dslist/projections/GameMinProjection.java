package com.devsuperior.dslist.projections;

//interface que recebe a consulta SQL native Query
public interface GameMinProjection {
	
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	

}
