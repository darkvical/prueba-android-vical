package com.vical.prueba.ui;

import com.vical.prueba.R;
import com.vical.prueba.util.Constantes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OperarUI extends Activity {
	private EditText valor1;
	private EditText valor2;
	private Spinner spiOperar;
	private TextView resultado;
	private EditText usuario;
	private EditText password;
	private String mensaje;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.operarui);
		Bundle bundleRecepcion=getIntent().getExtras();
		usuario=(EditText)findViewById(R.id.txtUsuario);
		password=(EditText)findViewById(R.id.txtPass);
		valor1=(EditText)findViewById(R.id.txtValor1);
		valor2=(EditText)findViewById(R.id.txtValor2);
		spiOperar=(Spinner)findViewById(R.id.spiOperar);
		resultado=(TextView)findViewById(R.id.lblResultado);
		setMensaje(bundleRecepcion.getString("mensaje"));
		String []opciones={"Sumar","Restar","Multiplicar","Dividir"};
		ArrayAdapter<String> adapterOperar=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opciones);
		spiOperar.setAdapter(adapterOperar);
	}
	
	public void operar(View view){
		int numero1, numero2;
		double resultado;
		int selectOperar;
		numero1=Integer.parseInt(valor1.getText().toString());
		numero2=Integer.parseInt(valor2.getText().toString());
		selectOperar=spiOperar.getSelectedItemPosition();
		switch (selectOperar) {
		case Constantes.OPERACION.SUMAR:
			resultado=numero1+numero2;
			break;
		case Constantes.OPERACION.RESTAR:
			resultado=numero1-numero2;
			break;
		case Constantes.OPERACION.MULTIPLICAR:
			resultado=numero1*numero2;
			break;
		case Constantes.OPERACION.DIVIDIR:
			resultado=numero1/numero2;
			break;
		default:
			resultado=0;
			break;
		}
		this.resultado.setText(String.valueOf(resultado+getMensaje()));
		Toast.makeText(this, getMensaje(), Toast.LENGTH_SHORT).show();
	}
	
	public void salir(View view){
//		usuario.setText("");
//		password.setText("");
		finish();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
