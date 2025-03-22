package br.inatel.dm112;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.inatel.dm112.model.dao.PedidoRepository;
import br.inatel.dm112.model.entities.PedidoEntity;

@SpringBootApplication
public class LogisticaApp implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(LogisticaApp.class, args);
	}

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception
	{
		PedidoEntity pedido1 = new PedidoEntity(1, "12312312300", "tandreycruz@yahoo.com.br", 150.70f, new Date(), 0);
		pedidoRepository.save(pedido1);
		PedidoEntity pedido2 = new PedidoEntity(2, "12345678901", "taibe.andrey@pg.inatel.br", 18.90f, new Date(), 0);
		pedidoRepository.save(pedido2);
	}
}