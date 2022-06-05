package net.registro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import net.registro.model.Factura;
import net.registro.services.IFacturasService;

@Controller
@RequestMapping("/facturas")
public class FacturasController {

	@Autowired
	private IFacturasService facServ;
	
	@GetMapping("/index")
	public String facturas(Model model) {
		List<Factura> lista = facServ.buscarTodos();
    	model.addAttribute("facturas", lista);
		return "facturas/facturas";
	}
	
	@GetMapping("/ingfacturas")
	public String facturas(Factura factura) {
	
		return "facturas/formFacturas";
	}
	
	@PostMapping("/guardar")
	public String factura(Factura factura, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "facturas/formFacturas";
		}	
		System.out.println(factura.getIdFactura());
    	facServ.guardar(factura);
    	attributes.addFlashAttribute("msg", "Se a guardado. Ale!, vamo ingresa otra!");
    	
		return "redirect:/facturas/indexPaginate";
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Factura> lista = facServ.buscarTodas(page);
		model.addAttribute("facturas", lista);
		return "facturas/facturas";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idFactura, Model model) {		
		Factura factura = facServ.buscarPorId(idFactura);			
		model.addAttribute("factura", factura);
		return "facturas/formFacturas";
	}
	
	/**
	 * MÃ©todo para eliminar una CategorÃ­a de la base de datos
	 * @param idCategoria
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idFactura, RedirectAttributes attributes) {
		
		// Eliminamos la categoria.
		facServ.eliminar(idFactura);
			
		attributes.addFlashAttribute("msg", "La factura fue eliminada!.");
		//return "redirect:/categorias/index";
		return "redirect:/facturas/indexPaginate";
	}
	
	@GetMapping("/busqueda/{id}")
	public String busqueda(@PathVariable("id") int idFactura, Model model) {
		Factura fac = facServ.buscarPorId(idFactura);
		System.out.println(fac.getDateV());
		List<Factura> lista = facServ.buscarVencimientos(fac.getDateV());
		Double totalV = 0.0;
		for(Factura f :lista) {
			totalV = f.getImporte() + totalV;
		}
		
    	model.addAttribute("facturas", lista);
    	model.addAttribute("totalV", totalV);
    	model.addAttribute("dateV", fac.getDateV());
    	
		return "facturas/vencimientos";
	}
	
	@GetMapping("/vencimientos")
	public String vencimientos() {
			
		return "facturas/vencimientos";
	}
	
}
