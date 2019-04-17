package br.com.ccee.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ccee.model.FuncionarioModel;
import br.com.ccee.model.beans.FuncionarioBean;

public class FuncionarioController {

	private FuncionarioModel fm = new FuncionarioModel();
	
	public List<FuncionarioBean> calcularSalarioLiquidoDosFuncionarios(){
		// Recupera os funcion�rios e seus descontos
		List<FuncionarioBean> funcionarios = fm.getFuncionarios();
		for(FuncionarioBean f : funcionarios)  {
			f.setDescontos(fm.getDescontos(f.getIdCliente()));
		}
		return funcionarios;
	}
	
	public List<FuncionarioBean> ordenarSalarioLiquidoDosFuncionarios(List<FuncionarioBean> fList){
		fList = fList.stream().sorted(Comparator.comparing(FuncionarioBean::getVlSalarioLiquido).reversed()).collect(Collectors.toList());
		return fList;
	}
}
