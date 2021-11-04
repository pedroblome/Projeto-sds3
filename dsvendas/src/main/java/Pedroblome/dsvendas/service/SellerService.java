package Pedroblome.dsvendas.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pedroblome.dsvendas.dto.SellerDto;
import Pedroblome.dsvendas.entities.Seller;
import Pedroblome.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository repository;

	public List<SellerDto> findAll(){
		List<Seller> result =  repository.findAll();
		return result.stream().map(x -> new SellerDto(x)).collect(Collectors.toList());
	}
}
