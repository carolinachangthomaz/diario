package com.carolinathomaz.api.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
    
	//public static  LocalDate date = LocalDate.of(2018, 11, 25);
	
	public static  LocalDate date = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
	
	public static LocalDate getHoje() {
		return date;
	}
	
	public static String getHojeFormat() {
		return date.format(formatters);
	}
	
	public static LocalDate getOntem() {
		return date.minusDays(1);
	}
	
	public static boolean isOntemDomingo() {
		return getOntem().getDayOfWeek().name().equals("SUNDAY") ? true : false;
	}
	
	public static boolean isDiaSeguinte() {
		Period periodo = Period.between(date, getOntem());
		return (periodo.getDays() == -1)? true : false; 
	}
	
}
