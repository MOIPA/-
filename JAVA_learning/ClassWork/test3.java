interface Vehicle{
	public void Start();
	public void Stop();
}
class Bike implements Vehicle{
	public void Start() {
	System.out.println("Bike Start");	
	}
	public void Stop() {
	System.out.println("Bike stop");	
	}
	
}
class Bus implements Vehicle{
	
	public void Start() {
	System.out.println("Bus start");	
	}
	public void Stop() {
	System.out.println("Bus stop");	
	}
}
public class test3 {
	public static void main(String[] args) {
		Bike bike = new Bike();
		Bus bus = new Bus();
		bike.Start();
		bike.Stop();
		bus.Start();
		bus.Stop();
	}
}
