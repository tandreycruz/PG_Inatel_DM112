package br.inatel.dm112.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.dm112.model.dao.PedidoRepository;
import br.inatel.dm112.model.entities.PedidoEntity;

@Service
public class PedidoService
{
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<PedidoEntity> buscarPedidos()
	{
		// PEDIDOS A SEREM ENTREGUES
		List<PedidoEntity> vPedidoEntity = pedidoRepository.findAllBySituacao(0);
		return vPedidoEntity;
	}

	public PedidoEntity buscarPedidoAberto(Integer idPedido)
	{
		if (idPedido == null || idPedido < 1)
		{
			System.out.println("É obrigatório informar o ID do Pedido.");
			return null;
		}
		else
		{
			PedidoEntity pedidoEntity = pedidoRepository.findByIdPedido(idPedido);
			if (pedidoEntity != null)
			{
				return pedidoEntity;
			}
			System.out.println("Nenhum pedido aberto foi encontrado para o ID informado.");
			return null;
		}
	}

	public void atualizarPedido(PedidoEntity pedidoEntity)
	{
		pedidoEntity.setSituacao(2); // ENTREGUE
		pedidoRepository.save(pedidoEntity);
	}
}
