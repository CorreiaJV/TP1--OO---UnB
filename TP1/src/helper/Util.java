package helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Util {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	static NumberFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

	
	public static void pausar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			System.out.println("Erro ao pausar por " +segundos + "segundos");
		}
	}
	
	public static String doubleParaString(Double valor) {
		return Util.nf.format(valor);
	}
	
	
}
