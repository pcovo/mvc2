package br.com.ccee.model.dao.implementacoes;

import static br.com.ccee.model.dao.ConnectionFactory.getConnection;
import static java.util.Arrays.asList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.ccee.CCEERuntimeException;
import br.com.ccee.model.beans.DescontosBean;
import br.com.ccee.model.beans.FuncionarioBean;
import br.com.ccee.model.dao.implementacoes.dbs.Oracle;
import br.com.ccee.model.dao.interfaces.Consultas;

public class ConsultasJDBC implements Consultas {

	

	@Override
	//Esta estrutura dispensa a chamada manual do Close das conexões
	public List<FuncionarioBean> getFuncionarios(){
		List<FuncionarioBean> funcionarios = asList();
		try (Connection con = getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(Oracle.SELECT)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						funcionarios.add(transformarResultEmFuncionario(resultSet));
					}
				}
			}
		} catch (SQLException sqlException) {
			throw new CCEERuntimeException(sqlException);
		}		
		return funcionarios;
	}

	protected FuncionarioBean transformarResultEmFuncionario(ResultSet resultSet) throws SQLException {
		FuncionarioBean funcionario = new FuncionarioBean();
		funcionario.setIdCliente(resultSet.getInt("id_cliente"));
		funcionario.setNomeCliente(resultSet.getString("nm_cliente"));
		funcionario.setVlSalarioBruto(resultSet.getBigDecimal("vl_salario_bruto"));
		return funcionario;		
	}

	@Override
	//Esta estrutura dispensa a chamada manual do Close das conexões
	public List<DescontosBean> getDescontos(Integer idFuncionario){
		List<DescontosBean> descontos = asList();
		try (Connection con = getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(Oracle.SELECT_BY_ID_CLIENTE)) {
				preparedStatement.setLong(1, idFuncionario);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						descontos.add(transformarResultEmDesconto(resultSet, idFuncionario));
					}
				}
			}
		} catch (SQLException sqlException) {
			throw new CCEERuntimeException(sqlException);
		}
		return descontos;
	}

	protected DescontosBean transformarResultEmDesconto(ResultSet resultSet, Integer idFuncionario) throws SQLException {
		DescontosBean desconto = new DescontosBean();
		desconto.setIdCliente(idFuncionario);
		desconto.setIdDesconto(resultSet.getInt("id_desconto"));
		desconto.setDesconto(resultSet.getBigDecimal("vl_desconto"));
		return desconto;		
	}
}
