package br.gov.bcb.dicel.mensageria.epm.dto.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

public class DataUtil {
	
	private static String[] dateTimePatterns = {"dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy HH:mm:ss.SSS", "ddMMyyyy HH:mm:ss.SSS"};
	private static String[] datePatterns = {"dd/MM/yyyy", "ddMMyyyy"};

	/**
	 * Cria um objeto tipo Date a partir de uma String
	 * com a seguinte formatação: dd/MM/yyyy 
	 * @param data data em String
	 * @return data em sql.Date
	 */
	public static Date converteParaSQLDate(String data){
		try {
			return new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(data).getTime());
		} catch (ParseException | NullPointerException e) {
			return null;
		}
	}
	
	public static LocalDate converteParaSqlLocalDate(String data){
		try {
			if(data == null || "".equals(data)){
				return null;
			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return LocalDate.parse(data, dtf);
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	public static Date converteParaSQLDateFinal(String data){
		try {
			Date date = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(data).getTime());
			LocalDateTime atStartOfDay = date.toLocalDate().plusDays(1).atStartOfDay();
			return Date.valueOf(atStartOfDay.toLocalDate());
		} catch (ParseException | NullPointerException e) {
			return null;
		}
	}
	
	@Deprecated
	public static LocalDateTime converteParaSQLDateHourFinal(String data, String hora){
		LocalDateTime especifico = null;
		try {
			
			if(data == null || "".equals(data)  || hora == null || "".equals(hora)){
				return null;
			}

			String arrayData[] = data.split("/");
			
			if(arrayData.length != 3){
				return null;
			}
			
			String arrayHora[] = hora.split(":");
			
			if(arrayHora.length != 3){
				return null;
			}
			
			especifico = LocalDateTime.of(Integer.parseInt(arrayData[2]), Month.of(Integer.parseInt(arrayData[1])), Integer.parseInt(arrayData[0]), Integer.parseInt(arrayHora[0]), Integer.parseInt(arrayHora[1]));
			
			if(arrayHora[2] != null && arrayHora[2].split("\\.").length > 1){
				especifico = especifico.withSecond(Integer.parseInt(arrayHora[2].split("\\.")[0]));
				especifico = especifico.with(ChronoField.MILLI_OF_SECOND, Long.parseLong(arrayHora[2].split("\\.")[1]));
			}else{
				especifico = especifico.withSecond(Integer.parseInt(arrayHora[2]));
			}
			return especifico;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public static LocalDateTime toLocalDateTime(String data){
		
		for(String pattern : dateTimePatterns){
			try{
				return LocalDateTime.parse(data, DateTimeFormatter.ofPattern(pattern));
			}catch(DateTimeParseException e){}
		}
		return null;
	}
	
	public static String toLocalDateString(LocalDate data) {
		if (data != null) {
			return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} else {
			return "";
		}
	}
	
	public static String toDateString(LocalDateTime data){
		if(data != null){
			return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}else{
			return "";
		}
	}
	
	public static String toTimeString(LocalDateTime data){
		if(data != null){
			return data.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		}else{
			return "";
		}
	}
	
	public static String toDateTimeString(LocalDateTime data){
		if(data != null){
			return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		}else{
			return "";
		}
	}
	
	public static String toDateTimeMillisString(LocalDateTime data){
		if(data != null){
			return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS"));
		}else{
			return "";
		}
	}
	
	public static String converteSqlDateToString(Date data) {
		if(data != null) {
			
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			return dateformat.format(data);
			
		}else {
			return "";
		}
	}
	
	public static String converteJavaDateToString(java.util.Date data) {
		if(data != null) {
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			return dateformat.format(data);
		}
		return "";
	}
	public static LocalDate toLocalDate(String data){
		if (data == null) {
			return null;
		}
		for(String pattern : datePatterns){
			try{
				return LocalDate.parse(data, DateTimeFormatter.ofPattern(pattern));
			}catch(DateTimeParseException e){}
		}
		return null;
	}
	

	
}
