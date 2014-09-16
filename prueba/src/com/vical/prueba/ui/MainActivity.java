package com.vical.prueba.ui;

import com.vical.prueba.R;
import com.vical.prueba.dao.SQLiteConection;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
	
	private EditText txtUsuario;
	private EditText txtPassword;
	private CheckBox chkNuevoRegistro;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteConection conection=new SQLiteConection(this, "Administrador", null, 1);
//        SQLiteDatabase dbConection=conection.getWritableDatabase();
//        conection.onCreate(dbConection);
    	txtUsuario=(EditText)findViewById(R.id.txtUsuario);
    	txtPassword=(EditText)findViewById(R.id.txtPassword);
    	chkNuevoRegistro=(CheckBox)findViewById(R.id.chkNuevoUsuario);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View view) {
		switch (view.getId()) {		
		case R.id.btnIngresar:
			if(chkNuevoRegistro.isChecked()){
				Intent intentRegistro=new Intent(this, RegistroUI.class);
				startActivity(intentRegistro);
			}else{
				String txtUsuario;
				txtUsuario=this.txtUsuario.getText().toString();
		    	Intent intentPrincipal=new Intent(this, PrincipalUI.class);
		    	intentPrincipal.putExtra("Mensaje", txtUsuario);
		    	startActivity(intentPrincipal);
			}	    	
//	    	Toast.makeText(this, "Entro metodo", Toast.LENGTH_SHORT).show();
	    	
			break;
		};
	}
}
