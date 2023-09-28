package controllers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.ReservaDao;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservasController {

	private ReservaDao reservaDao;
	
	public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.reservaDao = new ReservaDao(connection);
	}
	
	public void inserir(Reserva reserva) {
		this.reservaDao.insertReserva(reserva);
	}
	
	public List<Reserva> buscar()  {
		return this.reservaDao.buscar();
	}
	
	public List<Reserva> buscarReservaId(Long id)  {
		return this.reservaDao.buscarPorId(id);
	}

	public void atualizar(Date dataEntrada, Date dataSaida, BigDecimal valor, String formaPagamento, Long id) {
		this.reservaDao.atrualizar(dataEntrada, dataSaida, valor, formaPagamento, id);
		
	}

	public void deletar(Long id) {
		this.reservaDao.deletar(id);
		
	}
	
}
