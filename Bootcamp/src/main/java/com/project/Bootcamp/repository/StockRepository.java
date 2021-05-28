package com.project.Bootcamp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Bootcamp.model.Stock;
import com.project.Bootcamp.model.dto.StockDTO;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	 // se ja essiste no mesmo dia findByNameAndDate tem que ter os mesmos nomes nos atributos da model Stock
	// pega o nome E data optional.
	Optional<Stock> findByNameAndDate(String name, LocalDate date); //
	
	
	// para eu montar essa query com o nome que eu quiser.
	//vai deixar mudar a data preco nome  so se nao existir base de dados esse produto no mesmo dia 
	@Query("SELECT stock FROM Stock stock WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")  // devolva um stock que ja tenha o nome data  e NAO SEJA o mesmo id <>
	Optional<Stock> findByStockUpdate(String name, LocalDate date, long id);

	@Query("SELECT stock FROM Stock stock WHERE stock.date =  :date")  // so poega estoque de hoje     
	Optional <List<Stock>> findByToday(LocalDate date);
	
}
