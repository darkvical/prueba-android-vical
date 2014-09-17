package com.vical.prueba.service.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.vical.prueba.dao.SQLConnection;
import com.vical.prueba.service.ConnectionService;
import com.vical.prueba.util.Constantes;

public class ConnectionServiceImpl implements ConnectionService{

	@Override
	public void incializarUsuario(Context context) {
		SQLConnection admin = new SQLConnection(context,Constantes.SQLSENTENCIAS.DATABASE, null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		ContentValues registro;
		int pass;
		for (int i = 1; i < 10; i++) {
			registro = new ContentValues();
			double aleatorio=100*Math.random();
			pass=(int)aleatorio;			
	        registro.put("id_usuario", i);
	        registro.put("usuario", "vical");
	        registro.put("password", "vic"+pass+"naru");
	        registro.put("nombre", "Victor");
	        registro.put("apellido", "Rodriguez");
	        registro.put("dni", "46104922");
	        bd.insert(Constantes.SQLSENTENCIAS.USUARIO, null, registro);	        
		}
		registro = new ContentValues();
		registro.put("id_usuario", 10);
        registro.put("usuario", "vical");
        registro.put("password", "asakura");
        registro.put("nombre", "Victor");
        registro.put("apellido", "Rodriguez");
        registro.put("dni", "46104922");
        bd.insert(Constantes.SQLSENTENCIAS.USUARIO, null, registro);		
		bd.close();
	}

	@Override
	public boolean verificarUsuario(Context context,String usuario, String pass) {
		boolean existe;
		SQLConnection admin = new SQLConnection(context,Constantes.SQLSENTENCIAS.DATABASE, null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery(Constantes.SQLSENTENCIAS.CONSULTA_USUARIO+"usuario='" + usuario+"' and password='"+pass+"'", null);
        if (fila.getCount()>0) {
        	existe=true;
        }else{
        	existe=false;
        }            
        bd.close();		
		return existe;
	}

}
