package miexamen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccesoFichero {

	public static String leerJSON(String ruta_fichero) {
		String texto="";	
		try {
			FileReader fr=new FileReader(ruta_fichero);
			BufferedReader br=new BufferedReader(fr);
			
			String linea=br.readLine();
			while(linea!=null)
			{
				texto+=linea;
				linea=br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return texto;
	}

	public static void grabarTablaHTML(String tabla_html) {
		String ruta="D:\\CDM_FP\\tabla_coronavirus.html";
		String encabezado="<html><head>"
				+ "<style>"
				+ ".estilo_tabla{border: 1px solid blue}\n"
				+ ".estilo_tabla td{border: 1px solid blue}"
				+ "</style><title>Coronavirus en España</title><body>";
		String pie="</body></html>";
		String html_total=encabezado+tabla_html+pie;
		FileWriter fw=null;
		//Pongo false porque quiero que cada vez que se corra el programa, se cree el html de nuevo
		try {
			fw=new FileWriter(ruta, false);
			fw.write(html_total);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
