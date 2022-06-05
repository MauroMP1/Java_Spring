package net.registro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.registro.model.Factura;

public interface FacturasRepository extends JpaRepository<Factura, Integer> {
	
	Factura findByNumFact(String numFact);
	List<Factura> findByDateV(String dateV);
	
}
