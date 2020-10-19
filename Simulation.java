import java.time.LocalDate;
import java.util.ArrayList;

public class Midterm_20195156019 {

}

class Passenger {
	private String id;
	private String name;
	private int age;

	public Passenger(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Passenger() {

	}

	public String getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

abstract class MilesNSmilesMember extends Passenger {

	protected MilesNSmilesMember(String id, String name, int age) {
		super(id, name, age);

	}

	public abstract void addCardMiles(Flight flight);

	public abstract double getCardMiles();

	public abstract String getCardId();

	public abstract String loungePrivelage();

	public abstract String toString();

}

class ClassicMember extends MilesNSmilesMember {
	private String cardId;
	private static final double milePercentage = 0.1;
	private double cardMiles;

	protected ClassicMember(String id, String name, int age, String cardId) {

		super(id, name, age);
		this.cardId = cardId;
	}

	@Override
	public void addCardMiles(Flight flight) {
		cardMiles += milePercentage * flight.getMile();

	}

	@Override
	public double getCardMiles() {
		return this.cardMiles;

	}

	@Override
	public String getCardId() {

		return this.cardId;
	}

	@Override
	public String loungePrivelage() {
		if (this.cardMiles >= 500) {
			this.cardMiles = this.cardMiles - 500;
			return "Loung access is permitted";
		} else
			return "Lounge access is not permitted for " + this.getName();
	}

	@Override
	public String toString() {
		return "Classic Member: " + this.getName() + " Card Id: " + this.cardId + " Card Mile Total: " + this.cardMiles;
	}

}

class EliteMember extends MilesNSmilesMember {
	private String cardId;
	private static final double milePercentage = 0.3;
	private double cardMiles;

	protected EliteMember(String id, String name, int age, String cardId) {
		super(id, name, age);
		this.cardId = cardId;
	}

	@Override
	public void addCardMiles(Flight flight) {
		this.cardMiles += milePercentage * flight.getMile();
	}

	@Override
	public double getCardMiles() {

		return this.cardMiles;
	}

	@Override
	public String getCardId() {
		return this.cardId;
	}

	@Override
	public String toString() {
		return "Elite Member: " + this.getName() + " Card Id: " + this.cardId + " Card Mile Total: " + this.cardMiles;
	}

	@Override
	public String loungePrivelage() {

		return "Lounge access is permitted for " + this.getName();
	}

}

interface IAircraft {
	public static boolean default_availability = true;
	public static boolean default_safetyStat = true;
	public static final int defaultPilot_requ = 2;

	public String getModel();

	public String getTailNumber();

	public int getSeatCapacity();

	public int getPilotReq();

	public boolean getAvailability();

	public boolean getSafetyStat();

	public void setAvailability(boolean newStat);

	public void setSafetyStat(boolean newStat);

}

class CommercialPlane implements IAircraft {
	private String model;
	private String tailNumber;
	private int seatCapacity;
	private int pilot_req;
	private boolean availability;
	private boolean safetyStat;

	public CommercialPlane(String model, String tailNumber, int seatCapacity, int pilot_req) {
		this.model = model;
		this.tailNumber = tailNumber;
		this.seatCapacity = seatCapacity;
		this.availability = default_availability;
		this.safetyStat = default_safetyStat;
		this.pilot_req = pilot_req;

	}

	@Override
	public int getSeatCapacity() {
		return this.seatCapacity;
	}

	@Override
	public int getPilotReq() {
		return this.pilot_req;
	}

	@Override
	public boolean getAvailability() {
		return this.availability;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getTailNumber() {
		return this.tailNumber;
	}

	@Override
	public boolean getSafetyStat() {
		return this.safetyStat;
	}

	@Override
	public void setAvailability(boolean newStat) {
		this.availability = newStat;
	}

	@Override
	public void setSafetyStat(boolean newStat) {
		this.safetyStat = newStat;

	}

}

class JetPlane implements IAircraft {
	private String model;
	private String tailNumber;
	private int seatCapacity;
	private boolean availability;
	private boolean safetyStat;

	public JetPlane(String model, String tailNumber, int seatCapacity) {
		this.model = model;
		this.tailNumber = tailNumber;
		this.seatCapacity = seatCapacity;
		this.availability = default_availability;
		this.safetyStat = default_safetyStat;

	}

	@Override
	public int getSeatCapacity() {
		return this.seatCapacity;

	}

	@Override
	public int getPilotReq() {
		return JetPlane.defaultPilot_requ;
	}

	@Override
	public boolean getAvailability() {
		return this.availability;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getTailNumber() {
		return this.tailNumber;
	}

	@Override
	public boolean getSafetyStat() {
		return safetyStat;
	}

	@Override
	public void setAvailability(boolean newStat) {
		this.availability = newStat;
	}

	@Override
	public void setSafetyStat(boolean newStat) {
		this.safetyStat = newStat;
	}

}

class Pilot {
	private String name;
	private String id;
	private double hours_Flighted;
	private String license;

	public Pilot(String name, String id, String license) {
		this.name = name;
		this.id = id;
		this.license = license;
		this.hours_Flighted = 0;
	}

	public void addHours(double hours) {
		if (hours >= 0) {
			this.hours_Flighted += hours;
		}
	}

	public void initializeHours() {
		this.hours_Flighted = 0;
	}

	public boolean available() {
		if (this.hours_Flighted <= 100.0) {
			System.out.println("\nPilot " + this.name + " Id : " + this.id
					+ " is available for fligth with weekly hours flighted " + this.hours_Flighted + "\n ");
			return true;
		} else
			return false;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public double getHoursFlighted() {
		return this.hours_Flighted;
	}

	@Override
	public String toString() {
		return "Name :" + this.name + " Id :" + this.id + " License : " + this.license;
	}

	public String getLicense() {
		return license;
	}

}

class Flight {
	private String flightId;
	private Pilot[] pilot;
	private String departureAirport;
	private String arrivalAirport;
	private String date;
	private String time;
	private double mile;
	private String reqLicense;
	private IAircraft plane;

	public Flight(String flightId, String departureAirport, String arrivalAirport, double mile, String date,
			String time) {
		this.flightId = flightId;
		this.setDepartureAirport(departureAirport);
		this.setArrivalAirport(arrivalAirport);
		this.mile = mile;
		this.date = date;
		this.time = time;

	}

	public String getFlightId() {
		return flightId;
	}

	public void addPilot(Pilot pilot1) throws PilotNotValidException {
		// If pilot got the license for required flight then it can be assigned to the
		// flight
		for (int i = 0; i < this.pilot.length; i++) {
			if (this.pilot[i] == null) {
				if (reqLicense == pilot1.getLicense() && pilot1.available() == true) {
					this.pilot[i] = pilot1;
					break;

				}

				else {
					throw new PilotNotValidException(pilot1, this.reqLicense, pilot1.getHoursFlighted());
				}
			}
		}

	}

	public void getPilots() {
		System.out.println("Pilots assigned to the flight " + this.flightId + " are :");
		for (int i = 0; i < pilot.length; i++) {
			System.out.println(pilot[i]);
		}
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public IAircraft getPlane() {
		return this.plane;
	}

	public String assignPlane(IAircraft plane) {
		if (plane.getAvailability() == true && plane.getSafetyStat() == true) {
			this.pilot = new Pilot[plane.getPilotReq()];
			reqLicense = plane.getModel();

			this.plane = plane;
			plane.setAvailability(false);
			return "\nPlane " + plane.getModel() + " with tail number " + plane.getTailNumber() + " is assigned to "
					+ this.flightId;
		} else
			return "\nPlane " + plane.getModel() + " with tail number " + plane.getTailNumber() + " is not assigned to "
					+ this.flightId;
	}

	public double getMile() {
		return mile;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getCharterPrice() {
		return this.mile * 10.1;
	}

	@Override
	public String toString() {
		return "Flight No: " + this.flightId;
	}

}

class SalesCounter {
	private Flight flight;
	private ArrayList<Passenger> passenger;
	private double initialprice;
	private int capacity;
	private String[] seats;
	private int line;
	private double totalRevenue;

	public SalesCounter(Flight flight, double initialprice) {
		this.flight = flight;
		this.initialprice = initialprice;
		this.passenger = new ArrayList<Passenger>();
		this.capacity = flight.getPlane().getSeatCapacity();
		if (capacity % 6 != 0) {
			int a = capacity % 6;
			capacity = capacity - a;
			line = capacity / 6 + 1;
			capacity = flight.getPlane().getSeatCapacity();
		}
		this.seats = new String[capacity];
		String[] harf = { "A", "B", "C", "D", "E", "F" };
		int m = 0;

		for (int i = 1; i < line; i++) {
			for (int j = 0; j < 6; j++) {
				seats[m] = i + harf[j % 6];
				m++;
			}

		}
	}

	public double getPrice() {
		if (this.passenger.size() < this.flight.getPlane().getSeatCapacity() * 30 / 100)
			return initialprice;
		else if (this.passenger.size() < this.flight.getPlane().getSeatCapacity() * 50 / 100)
			return initialprice * 1.50;
		else
			return initialprice * 2;
	}

	public String buyTicket(Passenger passenger, double payment) throws NotAvailableSeatException {
		if (capacity - this.passenger.size() > 0 && !this.passenger.contains(passenger)) {
			if (payment >= this.getPrice()) {
				this.passenger.add(passenger);
				totalRevenue += this.getPrice();
				String m = "Date of your purchase is " + LocalDate.now() + " Cost of your purchase is "
						+ this.getPrice() + "$";
				return m;
			} else
				return "Not enought payment ";
		} else
			throw new NotAvailableSeatException(passenger);
	}

	public String CheckIn(Passenger passenger) {
		if (this.passenger.contains(passenger)) {
			return "\n" + passenger.getName() + " Seat : " + seats[this.passenger.size() - 1] + "\n"
					+ "Flight Number : " + flight.getFlightId() + "\nDeparture Airport : "
					+ flight.getDepartureAirport() + "\nArrival Airport : " + flight.getArrivalAirport()
					+ "\nDate of Departure : " + flight.getDate() + "\nTime of Departure : " + flight.getTime();
		} else
			return "this passenger" + passenger.getName() + " is not found";

	}

	public String displayPassenger() {
		String m = "";
		for (int i = 0; i < this.passenger.size(); i++) {
			m += passenger.get(i).getName() + "\n";
		}
		return m;
	}

	public double getTotalRevenue() {
		return this.totalRevenue;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public String assignPrivateFlight(Passenger passenger, Flight flight, double payment) {
		if (payment > flight.getCharterPrice()) {
			this.flight.getPlane().setAvailability(false);
			totalRevenue += flight.getCharterPrice();
			return "This Private Fligt assigned to passenger " + passenger.getName() + " CardId : " + passenger.getId()
					+ " \nCharter Price : " + flight.getCharterPrice() + "$" + "\nFlight Number : "
					+ flight.getFlightId() + "\nDeparture Airport : " + flight.getDepartureAirport()
					+ "\nArrival Airport : " + flight.getArrivalAirport() + "\nDate of Departure : " + flight.getDate()
					+ "\nTime of Departure : " + flight.getTime() + "\nJet Plane : " + flight.getPlane().getModel()
					+ "\nJet Plane Capacity for Passengers : " + flight.getPlane().getSeatCapacity();
		} else
			return "Payment is not concluded";
	}
}

class NotAvailableSeatException extends RuntimeException {
	private Passenger passenger;

	public NotAvailableSeatException(Passenger passenger) {
		this.passenger = passenger;
	}

	public NotAvailableSeatException() {

	}

	@Override
	public String toString() {
		return "NotAvailableSeatException: There is no seat available for " + this.passenger;
	}

}

class PilotNotValidException extends RuntimeException {
	private Pilot pilot;
	private String reqLicense;
	double hours;

	public PilotNotValidException(Pilot pilot, String reqLicense, double hours) {
		this.pilot = pilot;
		this.reqLicense = reqLicense;
		this.hours = hours;
	}

	public PilotNotValidException() {

	}

	@Override
	public String toString() {
		return "PilotNotValidException:  " + this.pilot + " Required License is " + this.reqLicense
				+ " \nRequired Hours_Flighted must me less than 100 hours\nThe Hours Flighted :" + this.hours;
	}

}
