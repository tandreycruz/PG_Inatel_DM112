package br.inatel.dm112.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.dm112.model.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>
{
	@Transactional(readOnly = true)
	List<PedidoEntity> findAll();

	@Transactional(readOnly = true)
	List<PedidoEntity> findAllBySituacao(int situacao);

	@Transactional(readOnly = true)
	PedidoEntity findByIdPedido(Integer idPedido);
}
