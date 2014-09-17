package com.vical.prueba.util;

public final class Constantes {
	
	public static class OPERACION{
		public final static int SUMAR			=0;
		public final static int RESTAR			=1;
		public final static int MULTIPLICAR		=2;
		public final static int DIVIDIR			=3;		
	}
	public static class VALIDACION{
		public final static String USUARIO		="vical";
	}
	
	public static class SQLSENTENCIAS{
		public final static String DATABASE			="DBUSER";
		public final static String USUARIO			="USUARIO";
		public final static String CREATE_USUARIO	="create table USUARIO (" +
				"id_usuario integer primary key," +
				"usuario text," +
				"password text," +
				"nombre text," +
				"apellido," +
				"dni text)";
		public final static String CONSULTA_USUARIO	="select id_usuario,usuario,password,nombre,apellido,dni from " +
				USUARIO+
				" where ";
	}
}
