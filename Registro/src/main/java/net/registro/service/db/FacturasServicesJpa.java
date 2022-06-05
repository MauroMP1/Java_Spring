package net.registro.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.registro.model.Factura;
import net.registro.repository.FacturasRepository;
import net.registro.services.IFacturasService;

@Service
public class FacturasServicesJpa implements IFacturasService {
	
	@Autowired
	private FacturasRepository facRepo;
	
	@Override
	public void guardar(Factura factura) {
		facRepo.save(factura);
		
	}

	@Override
	public void eliminar(Integer idFactura) {
		facRepo.deleteById(idFactura);
		
	}

	@Override
	public List<Factura> buscarTodos() {
		// TODO Auto-generated method stub
		return  facRepo.findAll();
	}

	@Override
	public List<Factura> buscarVencimientos(String dateV) {
		List<Factura> list = facRepo.findByDateV(dateV);
		if(list.size()> 1) {
			return list;
		}
		return null;
	}

	@Override
	public Factura buscarPorId(Integer idFactura) {
		Optional<Factura> optional = facRepo.findById(idFactura);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Factura buscarPornumFact(String numFact) {
		Factura fac = facRepo.findByNumFact(numFact);
		
		return fac;
	}

	@Override
	public Page<Factura> buscarTodas(Pageable page) {
		
		return facRepo.findAll(page);
	}

}
