package net.registro.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import net.registro.model.Factura;


public interface IFacturasService {

	void guardar(Factura factura);

	void eliminar(Integer idFactura);

	List<Factura> buscarTodos();

	List<Factura> buscarVencimientos(String dateV);

	Factura buscarPorId(Integer idFactura);

	Factura buscarPornumFact(String numFact);
	
	Page<Factura> buscarTodas(Pageable page);
	
	

}
