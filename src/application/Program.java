package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservetion;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("How many rooms to reserve? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn =  sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				Reservetion reservetion = new Reservetion(roomNumber, checkIn, checkOut);
				System.out.println(reservetion);
				
				System.out.println();
				System.out.println("Enter data to update the reservation: ");
				
				System.out.print("Check-in date (dd/MM/yyyy): ");
				checkIn =  sdf.parse(sc.next());
				System.out.print("Check-out date (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
				

				String error = reservetion.updateDates(checkIn, checkOut);
				
				if (error != null) {
					System.out.println("Error in reservetion: " + error);
				}else {
					System.out.println(reservetion);
				}
			}
		}
		sc.close();
	}
}
