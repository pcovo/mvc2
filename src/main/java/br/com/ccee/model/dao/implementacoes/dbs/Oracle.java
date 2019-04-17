package br.com.ccee.model.dao.implementacoes.dbs;

public class Oracle {

	public static final String SELECT_BY_ID_CLIENTE = " select id_desconto, vl_desconto from Descontos where id_cliente = ? ";
	public static final String SELECT = " select id_cliente, nm_cliente, vl_salario_bruto from Funcionario ";
	
}
