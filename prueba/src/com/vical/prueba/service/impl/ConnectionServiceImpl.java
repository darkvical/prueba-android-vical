package com.vical.prueba.service.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vical.core.impl.BaseUI;
import com.vical.core.util.Constantes;
import com.vical.prueba.dao.SQLiteConection;
import com.vical.prueba.domain.Cliente;
import com.vical.prueba.domain.Usuario;
import com.vical.prueba.service.ConnectionService;

public class ConnectionServiceImpl extends BaseUI implements ConnectionService{

	@Override
	public void crearCliente(Context context,Cliente cliente) {
		SQLiteConection admin = new SQLiteConection(context,Constantes.SQLNOMBREDB.NOMBRE_BD, null, 1);		
		SQLiteDatabase bd = admin.getWritableDatabase();
		ContentValues registroCliente;
		registroCliente = new ContentValues();
//		registroCliente.put("idCliente", cliente.getIdCliente());
		registroCliente.put("nombre", cliente.getNombre());
		registroCliente.put("apellidoPaterno", cliente.getApellidoPaterno());
		registroCliente.put("apellidoMaterno", cliente.getApellidoMaterno());
		registroCliente.put("documento", cliente.getDocumento());
//		registroCliente.put("correo", cliente.getCorreo());
        bd.insert(Constantes.SQLNOMBREDB.TABLA_CLIENTE, null, registroCliente);
        bd.close();
	}
	
	@Override
	public void crearUsuario(Context context,Usuario usuario) {		
		SQLiteConection admin = new SQLiteConection(context,Constantes.SQLNOMBREDB.NOMBRE_BD, null, 1);		
		SQLiteDatabase bd = admin.getWritableDatabase();
		ContentValues registroUsuario;
		
		registroUsuario = new ContentValues();
        registroUsuario.put("usuario", usuario.getUsuario());
        registroUsuario.put("password", usuario.getPassword());
        registroUsuario.put("cliente", usuario.getCliente());        
        bd.insert(Constantes.SQLNOMBREDB.TABLA_USUARIO, null, registroUsuario);		
		bd.close();
	}

	@Override
	public boolean verificarUsuario(Context context,String tablaNombre,String usuario, String password) {
		boolean existe;
		SQLiteConection admin = new SQLiteConection(context,Constantes.SQLNOMBREDB.NOMBRE_BD, null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String consulta=getConsulta(Constantes.SQLPARAMETROS.CAMPOS_USUARIO, Constantes.SQLNOMBREDB.TABLA_USUARIO, "usuario='" + usuario+"' and password='"+password+"'");
		Cursor fila = bd.rawQuery(consulta, null);
        if (fila.getCount()>0) {
        	existe=true;
        }else{
        	existe=false;
        }            
        bd.close();		
		return existe;
	}
	
	public Integer identificadorCliente(Context context,Cliente cliente){
		SQLiteConection admin = new SQLiteConection(context,Constantes.SQLNOMBREDB.NOMBRE_BD, null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String consulta=getConsulta(Constantes.SQLPARAMETROS.CAMPOS_CLIENTE, Constantes.SQLNOMBREDB.TABLA_CLIENTE, "documento='" + cliente.getDocumento()+"'");
		Cursor fila=bd.rawQuery(consulta, null);				
		if (fila.moveToFirst()){
			Integer identificador=new Integer(fila.getInt(0));
			bd.close();
			return identificador; 			
		}else{
			bd.close();
			return Constantes.SQLPARAMETROS.NO_EXISTE;
		}		
	} 
}
