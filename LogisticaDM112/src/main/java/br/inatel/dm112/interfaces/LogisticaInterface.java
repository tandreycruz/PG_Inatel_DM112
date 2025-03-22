package br.inatel.dm112.interfaces;

import java.util.List;

public interface LogisticaInterface
{
	public List<String> listarPedidosAbertos();

	public String registrarEntrega(Integer idPedido, String cpfRecebedor, String dataEntrega, String horaEntrega) throws Exception;
}
