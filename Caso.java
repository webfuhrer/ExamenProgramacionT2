package miexamen;

public class Caso {
private String parametro_dia;//Aqu� viene el d�a
private int valor_numero;//Aqu� viene el n�mero de casos
public String getParametro_dia() {
	return parametro_dia;
}
public void setParametro_dia(String parametro_dia) {
	this.parametro_dia = parametro_dia;
}
public int getValor_numero() {
	return valor_numero;
}
public void setValor_numero(int valor_numero) {
	this.valor_numero = valor_numero;
}
public Caso(String parametro_dia, int valor_numero) {
	super();
	this.parametro_dia = parametro_dia;
	this.valor_numero = valor_numero;
}

}
