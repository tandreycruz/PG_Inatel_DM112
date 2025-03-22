package br.inatel.dm112.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.dm112.interfaces.LogisticaInterface;
import br.inatel.dm112.model.entities.EntregaEntity;
import br.inatel.dm112.model.entities.PedidoEntity;
import br.inatel.dm112.services.EntregaService;
import br.inatel.dm112.services.PedidoService;

@RestController
@RequestMapping("/api")
public class LogisticaRest implements LogisticaInterface
{
	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private EntregaService entregaService;

	@GetMapping("/pedidos")
	public List<String> listarPedidosAbertos()
	{
		List<PedidoEntity> vPedidoEntity = pedidoService.buscarPedidos();
		List<String> vLista = new ArrayList<String>();
		for (PedidoEntity pedidoEntity : vPedidoEntity)
		{
			vLista.add(pedidoEntity.toString());
		}
		return vLista;
	}

	@PostMapping("/entregas/{idPedido}/{cpfRecebedor}/{dataEntrega}/{horaEntrega}")
	public String registrarEntrega(@PathVariable("idPedido")
	Integer idPedido, @PathVariable("cpfRecebedor")
	String cpfRecebedor, @PathVariable("dataEntrega")
	String dataEntrega, @PathVariable("horaEntrega")
	String horaEntrega) throws Exception
	{
		EntregaEntity entregaEntity = entregaService.registrarEntrega(idPedido, cpfRecebedor, dataEntrega, horaEntrega);
		System.out.println("Registro de Entrega Realizado");
		System.out.println("ID Entrega: " + entregaEntity.getIdEntrega());
		System.out.println("Data/Hora: " + entregaEntity.getDataHoraEntrega());
		System.out.println("CPF Recebedor: " + entregaEntity.getCpfRecebedor());
		System.out.println("Pedido: " + entregaEntity.getPedido().toString());
		String entrega = entregaEntity.toString();
		return entrega;
	}
}
