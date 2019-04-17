package br.com.ccee.model;

import java.util.List;

import br.com.ccee.model.beans.DescontosBean;
import br.com.ccee.model.beans.FuncionarioBean;
import br.com.ccee.model.dao.implementacoes.mock.ConsultasMock;
import br.com.ccee.model.dao.interfaces.Consultas;

public class FuncionarioModel implements Consultas{

//	private Consultas consultas = new ConsultasOracle();
	private Consultas consultas = new ConsultasMock();
	
	@Override
	public List<FuncionarioBean> getFuncionarios(){
		return consultas.getFuncionarios();
	}

	@Override
	public List<DescontosBean> getDescontos(Integer idFuncionario){
		return consultas.getDescontos(idFuncionario);
	}

}
