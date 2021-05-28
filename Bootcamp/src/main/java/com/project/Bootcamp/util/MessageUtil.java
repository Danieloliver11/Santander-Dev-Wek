package com.project.Bootcamp.util;
// essa classe facilita nossa manutencao futura. deixando as mensagens que se podem se repetir no nosso programa.

// abstract para ninguem instanciar essa classe já que o atributo  que esta aqui já é static.
public abstract class MessageUtil {
	
	public static final String STOCK_ALREDADY_EXISTS = "Estoque já existe no Banco de Dados!";
	
	public static final String NO_RECORDS_FOUND = "Nenhum registro encontrado";
}
