package com.programiranje.tamara_car.biblioteka.servisi.ui.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validacije {

	private static Scanner in = new Scanner(System.in);
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	public static Integer unosBroja(Integer min, Integer max) {
		while (true) {
			String unos = in.nextLine();
			if (unos.equalsIgnoreCase("x")) {
				return null;
			}

			try {
				int broj = Integer.parseInt(unos);

				if (min != null && broj < min) {
					System.out.println("Broj mora da bude veci ili jednak od " + min);
					continue;
				}
				if (max != null && broj > max) {
					System.out.println("Broj mora da bude manji ili jednak od " + max);
					continue;
				}

				return broj;

			} catch (Exception e) {
				System.out.println("Morate da unesete broj.");
				continue;
			}

		}

	}

	public static Integer unosBroja() {
		return unosBroja(null, null);
	}

	public static String unosTeksta(Integer min, Integer max) {
		while (true) {
			String unos = in.nextLine();
			unos = unos.strip();
			if (min != null && unos.length() < min) {
				System.out.println("Duzina teksta mora da bude veca ili jednaka od " + min);
				continue;
			}
			if (max != null && unos.length() > max) {
				System.out.println("Duzina teksta mora da bude manja ili jednaka od " + max);
				continue;
			}

			return unos;
		}

	}

	public static String unosTeksta() {
		return unosTeksta(null, null);
	}
	
	public static LocalDate unosDatuma (String unos) {
	
		try {
			LocalDate datum = LocalDate.parse(unos, dtf);
			return datum;
		} catch (Exception e) {
			return null;
		}
	}

	public static LocalDate parsiranDatum() {
		LocalDate datum;
		do {	
		 datum = unosDatuma(Validacije.unosTeksta());
		 if(datum == null) {
			 System.out.println("Neispravan format datuma, unesite ponovo: ");
		 }
		}while(datum==null);
		
		return datum;
		
		
		
	}

	public static String proveraMaila() {
		String tekst = "";
		while (!tekst.contains("@"))
			tekst = in.nextLine();
		return tekst;
	}

}
