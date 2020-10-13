package util;

import java.time.LocalDate;

public class Util {
	public static int[] formatarDataDeGuiParaLocalDate(String dataGui) {
		int[] dataFormatada = new int[3];
		dataFormatada[0] = Integer.parseInt(dataGui.substring(0, 2));
		dataFormatada[1] = Integer.parseInt(dataGui.substring(3, 5));
		dataFormatada[2] = Integer.parseInt(dataGui.substring(6, 10));
		return dataFormatada;
	}
	
	public static String formatarDataDeLocalDateParaGui(LocalDate dataLD) {
		StringBuilder dataFormatada = new StringBuilder();
		
		if(dataLD.getDayOfMonth() < 10) dataFormatada.append("0" + dataLD.getDayOfMonth() + "/");
		else dataFormatada.append(dataLD.getDayOfMonth() + "/");
		
		if(dataLD.getMonthValue() < 10) dataFormatada.append("0" + dataLD.getMonthValue() + "/");
		else dataFormatada.append(dataLD.getMonthValue() + "/");
		
		dataFormatada.append(dataLD.getYear());
		return dataFormatada.toString();
	}
}
