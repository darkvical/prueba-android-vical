package com.vical.prueba.dao;

import com.vical.prueba.util.Constantes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLConnection extends SQLiteOpenHelper {
	
	public SQLConnection(Context context,String name,CursorFactory cursorFactory,int version){
		super(context,name,cursorFactory,version);
	}

	@Override
	public void onCreate(SQLiteDatabase dbUsuario){
		//FIXME se crea la base de datos a utilizar por el aplicativo
		dbUsuario.execSQL(Constantes.SQLSENTENCIAS.CREATE_USUARIO);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	}

}
