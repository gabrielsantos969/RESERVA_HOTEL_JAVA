package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNunber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	public Reservation(Integer roomNunber, Date checkIn, Date checkOut) {
		
		this.roomNunber = roomNunber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}



	public Integer getRoomNunber() {
		return roomNunber;
	}

	public void setRoomNunber(Integer roomNunber) {
		this.roomNunber = roomNunber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String Updatedates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future";
		}else if (!checkOut.after(checkIn)) {
			return "Check-Out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNunber
				+ ", checj-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
