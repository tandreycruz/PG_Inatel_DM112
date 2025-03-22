package br.inatel.dm112.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.dm112.model.entities.EntregaEntity;
import br.inatel.dm112.model.entities.PedidoEntity;

@Service
public class EntregaService
{
	@Autowired
	PedidoService pedidoService;

	@Autowired
	MensageiroService mensageiroService;

	public EntregaEntity registrarEntrega(Integer idPedido, String cpfRecebedor, String dtEntrega, String hora) throws Exception
	{
		// ENCONTRAR PEDIDO
		PedidoEntity pedidoEntity = pedidoService.buscarPedidoAberto(idPedido);
		if (pedidoEntity == null)
		{
			System.out.println("Entrega não registrada.");
			return null;
		}
		// ATUALIZAR PEDIDO
		pedidoService.atualizarPedido(pedidoEntity);
		// PREPRAR DADOS ENTREGA
		Integer idEntrega = idPedido + 100;
		String dataHoraEntrega = dtEntrega + " " + hora;
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date dtHoraEntrega = formato.parse(dataHoraEntrega);
		// REGISTRAR ENTREGA
		EntregaEntity entregaEntity = new EntregaEntity(idEntrega, cpfRecebedor, dtHoraEntrega, pedidoEntity);
		// ENVIAR E-MAIL PARA O CLIENTE
		mensageiroService.callSendMailService(idPedido, pedidoEntity.getEmailcliente(), "E-MAIL DE CONFIRMACAO DE ENTREGA REALIZADA (Pedido: " + idPedido + " | CPF Recebedor: " + cpfRecebedor + " | Data/Hora Entrega: " + dataHoraEntrega + ".");
		//
		return entregaEntity;
	}
}
