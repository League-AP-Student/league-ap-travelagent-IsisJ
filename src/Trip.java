import java.util.List;

public class Trip {
	private List<Flight> flights;

	public int getDuration() {
		int duration = 0;
		Time departure;
		Time arrival;
		if(flights.size() < 0) {
			return 0;
		}
		for(Flight f : flights) {
			departure = f.getDeparturetime();
			arrival = f.getArrivalTime();
			duration = duration + departure.minutesUntil(arrival);
			departure = null;
			arrival = null;	
		}
		return duration;
	}

	public int getShortestLayover() {
		int shortest;
		int comparable;
		
		if(flights.size()<2) {
			return -1;
		}
		
		shortest = flights.get(0).getArrivalTime().minutesUntil(flights.get(1).getDeparturetime());
		
		for(int i=1; i<flights.size()-1; i++) {
			comparable = flights.get(i).getArrivalTime().minutesUntil(flights.get(i+1).getDeparturetime());
			if(shortest > comparable) {
				shortest = comparable;
			}
		}
		return shortest;
	}
}
