package miexamen;

import java.util.ArrayList;

public class PintarHTML {

	public static String crearTabla(ArrayList<Caso> lista_casos) {
		//Maximo casos: rgb(255, 0, 0)
		//Entre medias: rgb(r, 255-r, 0)
		//Minimo casos: rgb(0, 255, 0)
		int maximo_casos=buscarMaximo(lista_casos);
		int minimo_casos=buscarMinimo(lista_casos);
		//y=Ax+B
		//r=Ax+B (x es el número de casos)
		//255=A*maximo_casos+B
		//0=A*minimo_casos+B=>B=-A*minimo_casos
		//255-0=A*maximo_casos-A*minimo_casos+B-B
		//255=A*(maximo_casos-minimo_casos)
		//A=255/(maximo_casos-minimo_casos)
		//B=(-255/(maximo_casos-minimo_casos))*minimo_casos
		float A=(float)255/(float)(maximo_casos-minimo_casos);
		float B=-A*minimo_casos;
		
		String aux="<table class='estilo_tabla'><tr><th>Día</th><th>Numero casos</th></tr>";
		for (Caso caso : lista_casos) {
			int n_casos=caso.getValor_numero();
			float r=A*n_casos+B;
			float g=255-r;
			String rgb="rgb("+r+", "+g+", 0)";
			aux+="<tr style='color:"+rgb+"'><td>"+caso.getParametro_dia()+"</td><td>"+caso.getValor_numero()+
					"</td></tr>";
			
		}
		aux+="</table>";
		return aux;
	}

	private static int buscarMinimo(ArrayList<Caso> lista_casos) {
		int n=lista_casos.get(0).getValor_numero();
		for  (Caso caso: lista_casos)
		{
			int numero_casos=caso.getValor_numero();
			if(numero_casos<n)
			{
				n=numero_casos;
			}
		}
		return n;
	}

	private static int buscarMaximo(ArrayList<Caso> lista_casos) {
		//4,5,45,0,3,12,56,87
		int n=0;
	for (Caso caso : lista_casos) {
		int numero_casos=caso.getValor_numero();
			if (numero_casos>n)
			{
				n=numero_casos;
			}
		}
	return n;
	}

}
