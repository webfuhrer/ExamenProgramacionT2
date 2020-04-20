package miexamen;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClaseParser {

	public static ArrayList<Caso> parsearJSON(String texto_json) {
		ArrayList<Caso> lista_casos=new ArrayList();
		JSONObject objeto_json=new JSONObject(texto_json);
		JSONObject objeto_datos=objeto_json.getJSONObject("Datos");
		JSONArray lista_metricas=objeto_datos.getJSONArray("Metricas");
		for (int i=0; i<lista_metricas.length(); i++)
		{
			JSONObject objeto_metricas=lista_metricas.getJSONObject(i);
			JSONArray lista_obj_datos=objeto_metricas.getJSONArray("Datos");
			//Recorro la lista de "Datos":
			for (int j=0; j<lista_obj_datos.length(); j++)
			{
				//Aquí podríamos usar el método "getJSONObject".
				JSONObject objeto_dato=(JSONObject)lista_obj_datos.get(j);
				//Ahora recuperaré el Parámetro
				String parametro_dia=objeto_dato.getString("Parametro");
				int valor_num_casos=objeto_dato.getInt("Valor");
				Caso c=new Caso(parametro_dia, valor_num_casos);
				lista_casos.add(c);
			}
		}
		
			return lista_casos;	
	}

}
