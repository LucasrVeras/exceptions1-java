package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservetion {
	
	Integer roomNumber;
	Date checkIn;
	Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// Constructors
	public Reservetion() {
		super();
	}
	
	public Reservetion(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	// Methods
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}if (!checkOut.after(checkIn))  {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	// Getters and Setters
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	@Override
	public String toString() {
		return "Room " 
				+ roomNumber 
				+ ", CheckIn: " 
				+ sdf.format(checkIn) 
				+ ", CheckOut: " 
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " Nights";
	}
}