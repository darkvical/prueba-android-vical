package com.vical.prueba.dao;

import com.vical.prueba.util.Constantes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteConection extends SQLiteOpenHelper{
	
	public SQLiteConection(Context context, String name, CursorFactory factory,int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Constantes.SQLPARAMETROS.CREATE_CLIENTE);
		db.execSQL(Constantes.SQLPARAMETROS.CREATE_USUARIO);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(Constantes.SQLPARAMETROS.DROP_TABLE+Constantes.SQLNOMBREDB.TABLA_CLIENTE);	
		db.execSQL(Constantes.SQLPARAMETROS.CREATE_CLIENTE);		
		db.execSQL(Constantes.SQLPARAMETROS.DROP_TABLE+Constantes.SQLNOMBREDB.TABLA_USUARIO);
		db.execSQL(Constantes.SQLPARAMETROS.CREATE_USUARIO);
	}
}
