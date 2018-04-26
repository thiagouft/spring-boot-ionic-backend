package com.thiago.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.cursomc.domain.Pedido;
import com.thiago.cursomc.repositories.PedidoRepository;
import com.thiago.cursomc.services.exception.ObjectNotFoundException;
//import com.thiago.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired //vai ser automaticamente instanciada pelo Spring
	private PedidoRepository repo;
	
	/*public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElse(null);
	}*/
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}

}
