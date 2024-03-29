package com.vical.core.util;

public final class Constantes {
	
	public static class SPINNER{
		public final static Integer SUMA			=1;
		public final static Integer RESTA			=2;
		public final static Integer MULTIPICAR		=3;
		public final static Integer DIVIDIR			=4;
	}
	
	public static class SQLPARAMETROS{		
		public final static String CREATE_CLIENTE	="CREATE TABLE CLIENTE(" +
				"idCliente Integer primary key," +
				"nombre Text," +
				"apellidoPaterno Text," +
				"apellidoMaterno Text," +
				"documento Text," +
				"correo Text)";
		public final static String CREATE_USUARIO	="CREATE TABLE USUARIO(" +
				"idUsuario Integer primary key," +
				"usuario Text," +
				"password Text," +
				"cliente Integer)";
		public final static String 	CAMPOS_CLIENTE	="idCliente,nombre,apellidoPaterno,apellidoMaterno,documento";
		public final static String 	CAMPOS_USUARIO	="idUsuario,usuario,password,cliente";
		public final static String 	DROP_TABLE		="DROP TABLE IF EXISTS";
		public final static String 	SELECT_TABLE	="SELECT - FROM - WHERE ";
		public final static Integer NO_EXISTE		=0; 
	}
	public static class SQLNOMBREDB{
		public final static String NOMBRE_BD		="ADMINISTRACION";
		public final static String TABLA_CLIENTE	="CLIENTE";
		public final static String TABLA_USUARIO	="USUARIO";
	}
}
