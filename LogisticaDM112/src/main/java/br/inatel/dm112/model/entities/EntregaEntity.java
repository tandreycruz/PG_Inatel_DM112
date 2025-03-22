package br.inatel.dm112.model.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EntregaEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEntrega;

	private String cpfRecebedor;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraEntrega;

	private PedidoEntity pedido;

	public EntregaEntity(Integer idEntrega, String cpfRecebedor, Date dataHoraEntrega, PedidoEntity pedido)
	{
		this.idEntrega = idEntrega;
		this.cpfRecebedor = cpfRecebedor;
		this.dataHoraEntrega = dataHoraEntrega;
		this.pedido = pedido;
	}

	public Integer getIdEntrega()
	{
		return idEntrega;
	}

	public void setIdEntrega(Integer idEntrega)
	{
		this.idEntrega = idEntrega;
	}

	public String getCpfRecebedor()
	{
		return cpfRecebedor;
	}

	public void setCpfRecebedor(String cpfRecebedor)
	{
		this.cpfRecebedor = cpfRecebedor;
	}

	public Date getDataHoraEntrega()
	{
		return dataHoraEntrega;
	}

	public void setDataHoraEntrega(Date dataHoraEntrega)
	{
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public PedidoEntity getPedido()
	{
		return pedido;
	}

	public void setPedido(PedidoEntity pedido)
	{
		this.pedido = pedido;
	}

	@Override
	public String toString()
	{
		return "Entrega [idEntrega=" + idEntrega + ", cpfRecebedor=" + cpfRecebedor + ", dataHoraEntrega=" + dataHoraEntrega + ", idPedido=" + pedido.getIdPedido() + "]";
	}
}
