package br.com.ccee;

import br.com.ccee.view.FuncionarioView;

public class MainClass {
	public static void main(String args[]){
		if(args != null && args.length > 0)
			System.out.println(args[0]);
		
		FuncionarioView fw = new FuncionarioView();
		fw.apresentarRelacaoFuncionariosPorSalarioLiquidoDesc();
	}
}
