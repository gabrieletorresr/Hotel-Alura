package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.HospedeDao;
import factory.ConnectionFactory;
import modelo.Hospede;

public class HospedeController {

	
	private HospedeDao hospedeDao;
	
	public HospedeController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.hospedeDao = new HospedeDao(connection);
	}
	
	public void inserir(Hospede hospede) {
		this.hospedeDao.salvar(hospede);
	}
	
	public List<Hospede> buscarTodos() {
		return this.hospedeDao.listar();
	}
	
	public List<Hospede> listarSobrenome(String sobrenome) {
		return this.hospedeDao.listarSobrenome(sobrenome);
	}
	
	public void atualizar(String  nome, String sobrenome, Date dataNascimento, String nascionalidade, String telefone, 
			Long idReserva, Long id) {
		this.hospedeDao.atualizar(nome, sobrenome, dataNascimento, nascionalidade, telefone, idReserva, id);
	}
	
	public void deletar(Long id ) {
		this.hospedeDao.deletar(id);
	}

	public boolean registrarHospede(Hospede hospede) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
