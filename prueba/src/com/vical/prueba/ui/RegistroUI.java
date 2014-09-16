package com.vical.prueba.ui;

import com.vical.prueba.R;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistroUI extends Activity implements View.OnClickListener {

	private EditText txtNombre;
	private EditText txtApellido;
	private EditText txtUser;
	private EditText txtPass;
	private EditText txtConfirmPass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registroui);
		
		txtNombre=(EditText)findViewById(R.id.txtNombre);
		txtApellido=(EditText)findViewById(R.id.txtApellido);
		txtUser=(EditText)findViewById(R.id.txtUser);
		txtPass=(EditText)findViewById(R.id.txtPass);
		txtConfirmPass=(EditText)findViewById(R.id.txtConfirPass);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnRegistrar:
			ContentValues usuario=new ContentValues();
			usuario.put("nombre", txtNombre.getText().toString());
			usuario.put("apellido", txtApellido.getText().toString());
			usuario.put("usuario", txtUser.getText().toString());
			usuario.put("password", txtPass.getText().toString());						
			break;
		case R.id.btnCancelar:
			finish();
			break;
		}
	}

}
