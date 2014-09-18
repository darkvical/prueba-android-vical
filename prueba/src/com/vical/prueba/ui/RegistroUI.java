package com.vical.prueba.ui;

import com.vical.prueba.R;
import com.vical.prueba.domain.Cliente;
import com.vical.prueba.domain.Usuario;
import com.vical.prueba.service.impl.ConnectionServiceImpl;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroUI extends Activity implements View.OnClickListener {

	private EditText txtNombre;
	private EditText txtApellido;	
	private EditText txtDocumento;
	private EditText txtCorreo;
	
	private EditText txtUser;
	private EditText txtPass;
	private EditText txtConfirmPass;
	
	ConnectionServiceImpl connectionServiceImpl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registroui);
		connectionServiceImpl=new ConnectionServiceImpl();
		
		txtNombre=(EditText)findViewById(R.id.txtNombre);
		txtApellido=(EditText)findViewById(R.id.txtApellido);
		txtDocumento=(EditText)findViewById(R.id.txtDocumento);
		txtCorreo=(EditText)findViewById(R.id.txtCorreo);
		txtUser=(EditText)findViewById(R.id.txtUser);
		txtPass=(EditText)findViewById(R.id.txtPass);
		txtConfirmPass=(EditText)findViewById(R.id.txtConfirPass);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnRegistrar:			
			if(!txtPass.equals(txtConfirmPass)){
				Cliente cliente=new Cliente();
				Usuario usuario=new Usuario();				
				cliente.setNombre(txtNombre.getText().toString());				
				cliente.setApellidoPaterno(txtApellido.getText().toString());
				cliente.setApellidoMaterno(txtApellido.getText().toString());
				cliente.setDocumento(txtDocumento.getText().toString());
				cliente.setCorreo(txtCorreo.getText().toString());
				connectionServiceImpl.crearCliente(this, cliente);
				usuario.setUsuario(txtUser.getText().toString());
				usuario.setPassword(txtPass.getText().toString());
				usuario.setCliente(connectionServiceImpl.identificadorCliente(this, cliente));
				connectionServiceImpl.crearUsuario(this, usuario);
				cerrarRegistro();
			}else{
				Toast.makeText(this, "Verificar contraseña ingresada", Toast.LENGTH_SHORT).show();				
			}
									
			break;
		case R.id.btnCancelar:
			cerrarRegistro();
			break;
		}
	}
	
	public void cerrarRegistro(){
		finish();
	}
}
