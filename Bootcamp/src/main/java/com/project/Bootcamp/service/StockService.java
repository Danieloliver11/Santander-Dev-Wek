package com.project.Bootcamp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.Bootcamp.exceptions.BusinessException;
import com.project.Bootcamp.exceptions.NotFoundException;
import com.project.Bootcamp.mapper.StockMapper;
import com.project.Bootcamp.model.Stock;
import com.project.Bootcamp.model.dto.StockDTO;
import com.project.Bootcamp.repository.StockRepository;
import com.project.Bootcamp.util.MessageUtil;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockMapper stockMapper;

	@Transactional								// aqui faz uma transacao no banco de dados. Abro a transacao e fecho a transacao.
	public StockDTO save(StockDTO dto) {
		//Optional para estruturas condicionais pode ter ou nao ter.
		Optional<Stock> optionalStock = stockRepository.findByNameAndDate(dto.getName(), dto.getDate()); // se tiver, no Stock com o nome e data joga no optionalStock
		
		//**
		if(optionalStock.isPresent()) { // se tiver algum dado no optionalStock, assim nao deixamos ter dois objetos na mesma data.
			// retorno uma exceção se tiver
			
			throw new BusinessException(MessageUtil.STOCK_ALREDADY_EXISTS);// vai levar a mensagem de erro para o front. essa mensagem esta na camada Util
		}
		
		Stock stock = stockMapper.toEntity(dto);		
		 stockRepository.save(stock);
		 return stockMapper.toDto(stock); 				// pegando stocke e convertendo para dto
	}
	
	
	
	
	@Transactional
	public StockDTO update( StockDTO dto) {
		Optional<Stock> optionalStock = stockRepository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId()); 
		
		if(optionalStock.isPresent()) { 
			
			throw new BusinessException(MessageUtil.STOCK_ALREDADY_EXISTS);
		}
		Stock stock = stockMapper.toEntity(dto);
		stockRepository.save(stock);
		

		return stockMapper.toDto(stock);
	}


	// -
	@Transactional(readOnly = true) // garante que so é para leitura select que so me retorna verdadeiro
	public List<StockDTO> findall() {
		List<Stock> list = stockRepository.findAll();
		return stockMapper.toDto(list);
	}



	@Transactional
	public StockDTO findById(Long id) {
		
		return stockRepository.findById(id).map(stockMapper::toDto).orElseThrow(NotFoundException::new); // NotFoundException
	}



	@Transactional
	public StockDTO delete(Long id) {
		StockDTO dto = this.findById(id); // reutiliso o metodo findById para saber se tem ou nao id.
		
		stockRepository.deleteById(dto.getId()); // deleta o dto com id existente
		
		return dto;
	}



	@Transactional(readOnly = true)
	public List<StockDTO> findByToday() {
		
		return stockRepository.findByToday(LocalDate.now()) // LocalDate.now() pega a data de hoje 
				.map(stockMapper::toDto).orElseThrow(NotFoundException::new); // NotFoundException
	}
		
	
	
	

}
