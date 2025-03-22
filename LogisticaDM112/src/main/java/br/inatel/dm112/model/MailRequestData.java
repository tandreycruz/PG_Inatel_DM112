package br.inatel.dm112.model;

public class MailRequestData
{
	private int orderNumber;

	private String to;

	private byte[] content;

	private String mensagem;

	public MailRequestData()
	{
	}

	public MailRequestData(int orderNumber, String to, byte[] content, String mensagem)
	{
		this.orderNumber = orderNumber;
		this.to = to;
		this.content = content;
		this.mensagem = mensagem;
	}

	public int getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public String getTo()
	{
		return to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}

	public byte[] getContent()
	{
		return content;
	}

	public void setContent(byte[] content)
	{
		this.content = content;
	}

	public String getMensagem()
	{
		return mensagem;
	}

	public void setMensagem(String mensagem)
	{
		this.mensagem = mensagem;
	}

	@Override
	public String toString()
	{
		return "MailData [orderNumber=" + orderNumber + ", to=" + to + "]";
	}
}
