package miexamen;

import java.io.IOException;
import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		
	
		
		String ruta_fichero="D:\\CDM_FP\\casos_acumulados_de_coron.json";
		String texto_json=AccesoFichero.leerJSON(ruta_fichero);
		//Si parseo aquí el JSON, el método no lo puedo reutilizar en otro tipo de entornos
		//(Java swing, J2EE, etc...)
		ArrayList<Caso> lista_casos=ClaseParser.parsearJSON(texto_json);
		String tabla_html=PintarHTML.crearTabla(lista_casos);
		AccesoFichero.grabarTablaHTML(tabla_html);
		System.out.println(texto_json);
		
		String url = "file://D:\\CDM_FP\\tabla_coronavirus.html";
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSONObject o=new JSON

	}

}
