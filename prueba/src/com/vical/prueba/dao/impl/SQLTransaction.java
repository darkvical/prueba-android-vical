package com.vical.prueba.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vical.core.util.Constantes;
import com.vical.prueba.dao.SQLiteConection;

public class SQLTransaction {
	public void insertarUsuario(Context context,ContentValues contentValues,String nombreTabla){
		SQLiteConection conection=new SQLiteConection(context, Constantes.SQLNOMBREDB.NOMBRE_BD, null, 1);		
		SQLiteDatabase dbConection=conection.getWritableDatabase();
		dbConection.insert(nombreTabla, null, contentValues);
	}
	
	public void consultarUsuario(Context context,ContentValues contentValues,String nombreTabla,String condicion){
		SQLiteConection conection=new SQLiteConection(context, Constantes.SQLNOMBREDB.NOMBRE_BD, null, 1);		
		SQLiteDatabase dbConection=conection.getWritableDatabase();
		String consulta=new String(Constantes.SQLPARAMETROS.SELECT_TABLE);
		consulta.replaceAll("*tabla", nombreTabla);
		consulta.replaceAll("*campos", Constantes.SQLPARAMETROS.CAMPOS_USUARIO);
		consulta.replaceAll("*condicion", condicion);
		Cursor filaTabla=dbConection.rawQuery(consulta+"'"+""+"'", null);
	}
}
 