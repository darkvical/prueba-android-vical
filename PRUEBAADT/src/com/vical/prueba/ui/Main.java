package com.vical.prueba.ui;

import com.vical.prueba.R;
import com.vical.prueba.service.impl.ConnectionServiceImpl;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends ActionBarActivity {
	
	private EditText usuario;
	private EditText password;
	
	ConnectionServiceImpl connectionServiceImpl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		usuario=(EditText)findViewById(R.id.txtUsuario);
		password=(EditText)findViewById(R.id.txtPass);		
		connectionServiceImpl=new ConnectionServiceImpl();
		connectionServiceImpl.incializarUsuario(this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void ingresar(View view){
		Intent intentIngresar =new Intent(this,OperarUI.class);
		String usuario;
		String password;
		usuario=this.usuario.getText().toString();
		password=this.password.getText().toString();
		if(connectionServiceImpl.verificarUsuario(this, usuario, password)){
			intentIngresar.putExtra("mensaje", "Envio correcto");
			startActivity(intentIngresar);
		}else{
			Toast.makeText(this, "Usuario o password incorrecto",Toast.LENGTH_SHORT).show();
		}
	}	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
