package br.inatel.dm112.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pedido")
public class PedidoEntity
{
	public static enum SITUACAO
	{
		ABERTO, CANCELADO, ENTREGUE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;

	private String cpfCliente;

	private String emailcliente;

	private float valor;

	private Date dataPedido;

	private int situacao;

	public PedidoEntity()
	{
		super();
	}

	public PedidoEntity(Integer idPedido, String cpfCliente, String emailcliente, float valor, Date dataPedido, int situacao)
	{
		this.idPedido = idPedido;
		this.cpfCliente = cpfCliente;
		this.emailcliente = emailcliente;
		this.valor = valor;
		this.dataPedido = dataPedido;
		this.situacao = situacao;
	}

	public Integer getIdPedido()
	{
		return idPedido;
	}

	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}

	public String getCpfCliente()
	{
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente)
	{
		this.cpfCliente = cpfCliente;
	}

	public String getEmailcliente()
	{
		return emailcliente;
	}

	public void setEmailcliente(String emailcliente)
	{
		this.emailcliente = emailcliente;
	}

	public float getValor()
	{
		return valor;
	}

	public void setValor(float valor)
	{
		this.valor = valor;
	}

	public Date getDataPedido()
	{
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido)
	{
		this.dataPedido = dataPedido;
	}

	public int getSituacao()
	{
		return situacao;
	}

	public void setSituacao(int situacao)
	{
		this.situacao = situacao;
	}

	@Override
	public String toString()
	{
		return "[idPedido=" + idPedido + ", cpfCliente=" + cpfCliente + ", valor=" + valor + ", dataPedido=" + dataPedido + ", situacao=" + situacao + "]";
	}
}
