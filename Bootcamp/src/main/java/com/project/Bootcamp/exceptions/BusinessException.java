package com.project.Bootcamp.exceptions;
											//execao 
public class BusinessException  extends RuntimeException{
	
	public BusinessException(String Message) {
		super(Message); // devolve para a classe pai essa mesagem de erro
	}

}
