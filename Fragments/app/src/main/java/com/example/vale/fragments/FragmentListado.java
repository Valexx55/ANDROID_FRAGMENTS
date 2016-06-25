package com.example.vale.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentListado extends Fragment {
	
	private Libro[] datos =
	    	new Libro[]{
	    		new Libro("Libro 1", "J.Sallinger", "El libro es una chulada de un chaval que corre por el campo"),
	    		new Libro("Libro 2", "Fco Quevedo", "No se puede orinar donde hay cruces. No se ponen cruces donde se orina"),
	    		new Libro("Libro 3", "Bambarino", "La imaginación os hará libres"),
	    		new Libro("Libro 4", "Montalbán", "Y de como Mario Conde recorrió Cuba buscando pruebas"),
	    		new Libro("Libro 5", "Delibes", "Desde el campo castellano, todo se ve muy tranquilo")};
	
	private ListView lstListado;
	
	private ActividadPrincipal listener;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_listado, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		lstListado = (ListView)getView().findViewById(R.id.LstListado);
		
		lstListado.setAdapter(new AdaptadorCorreos(this));
		
		lstListado.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
					listener.onLibroSeleccionado(datos[pos]);

			}
		});
	}
	
	class AdaptadorCorreos extends ArrayAdapter<Libro> {
    	
    	Activity context;
    	
    	AdaptadorCorreos(Fragment context)
        {
    		super(context.getActivity(), R.layout.listitem_libro, datos);
    		this.context = context.getActivity();
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.listitem_libro, null);
			
			TextView lblDe = (TextView)item.findViewById(R.id.Titulo);
			lblDe.setText(datos[position].getTitulo());
			
			TextView lblAsunto = (TextView)item.findViewById(R.id.Autor);
			lblAsunto.setText(datos[position].getAutor());
			
			return(item);
		}
    }
	

	public void setLibrosListener (ActividadPrincipal listener) {
		this.listener=listener;
	}
}
