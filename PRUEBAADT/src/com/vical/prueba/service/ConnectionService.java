package com.vical.prueba.service;

import android.content.Context;

public interface ConnectionService {
	public void incializarUsuario(Context context);
	public boolean verificarUsuario(Context context, String usuario, String pass);
}
