package com.vical.core.impl;

import com.vical.core.util.Constantes;

public class BaseUI {
	public BaseUI(){
		
	}
	
	public String getConsulta(String campos,String nombreTabla,String condicion){		
		String consulta=new String(Constantes.SQLPARAMETROS.SELECT_TABLE);
		String[] entradaConsulta=consulta.split("-");
		consulta=entradaConsulta[0]+campos+entradaConsulta[1]+nombreTabla+entradaConsulta[2]+condicion;
		return consulta;		
	}
}
