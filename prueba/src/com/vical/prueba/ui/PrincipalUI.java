package com.vical.prueba.ui;

import com.vical.prueba.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PrincipalUI extends Activity {

	private TextView txtMensaje;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principalui);
		txtMensaje=(TextView)findViewById(R.id.txtMensaje);
		
		Bundle bundleRecepcion=getIntent().getExtras();//FIXME Permite recepcionar el parametro enviado
		txtMensaje.setText(String.valueOf(bundleRecepcion.getString("mensaje")));
	}	
}
