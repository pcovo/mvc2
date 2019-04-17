package br.com.ccee.model.dao.interfaces;

import java.util.List;

import br.com.ccee.model.beans.DescontosBean;
import br.com.ccee.model.beans.FuncionarioBean;

public interface Consultas {

	public List<FuncionarioBean> getFuncionarios();
	
	public List<DescontosBean> getDescontos(Integer idFuncionario);
}
