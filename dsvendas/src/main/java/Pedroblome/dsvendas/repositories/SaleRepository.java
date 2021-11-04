package Pedroblome.dsvendas.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Pedroblome.dsvendas.dto.SaleSuccessDto;
import Pedroblome.dsvendas.dto.SaleSumDto;
import Pedroblome.dsvendas.entities.Sale;


public interface SaleRepository extends JpaRepository<Sale, Long> {
	@Query("SELECT new Pedroblome.dsvendas.dto.SaleSumDto(obj.seller, SUM(obj.amount))"+
	" From Sale AS obj GROUP BY obj.seller")
	List<SaleSumDto> amountGroupedBySeller();

	@Query("SELECT new Pedroblome.dsvendas.dto.SaleSuccessDto(obj.seller, SUM(obj.visited), SUM(obj.deals))"+
			" From Sale AS obj GROUP BY obj.seller")
			List<SaleSuccessDto> successGroupedBySeller();
}
