package com.vical.prueba.service;

import com.vical.prueba.domain.Cliente;
import com.vical.prueba.domain.Usuario;

import android.content.Context;

public interface ConnectionService {
	public void crearCliente(Context context,Cliente cliente);
	public void crearUsuario(Context context,Usuario usuario);	
	public boolean verificarUsuario(Context context,String tablaNombre,String usuario, String password);
}
