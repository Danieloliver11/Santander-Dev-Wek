package com.project.Bootcamp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.project.Bootcamp.model.Stock;
import com.project.Bootcamp.model.dto.StockDTO;

//camada Mapper trasformar para fazer uma trasformacao de objetos STOCKDTO para STOCK

@Component 			// gerenciador 
public class StockMapper {
	
	public Stock toEntity(StockDTO dto) {
		// temos outras maneiras de fazer isso. como a biblioteca do http://modelmapper.org/getting-started/
		
		Stock stock = new Stock();
		
		stock.setId(dto.getId());
		stock.setName(dto.getName());    
		stock.setDate(dto.getDate());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		
		
		return stock;
	}
	
	public StockDTO toDto(Stock stock) {
		
		// retorna o dto como era para resposta com id no Response body (na tela de retorno "postman)
		
		StockDTO dto = new StockDTO();
		
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setDate(stock.getDate());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		
		return dto;
	}
	
	// sobrecarga toDto
	public List<StockDTO> toDto(List<Stock> listStock){
		
				//stream percorre a lista, .map() item a item, dentro dele manda this::(metodoToDto),que faz uma conversao de collectors para o tipo LIST
		return listStock.stream().map(this::toDto).collect(Collectors.toList()); 
	}

}
