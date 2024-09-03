package Utilitario;

import java.text.DecimalFormat;

public class Utils {

	static DecimalFormat formatandoValores = new DecimalFormat("R$ #,##0.");
	
	public static String doubleToString(Double valor) {
		return formatandoValores.format(valor);
	}
}
