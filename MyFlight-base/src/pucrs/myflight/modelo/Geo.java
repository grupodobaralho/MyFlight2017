package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;

	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	public static double distancia(Geo um, Geo dois) {
		double lat1 = Math.toRadians(um.latitude);
		double long1 = Math.toRadians(um.latitude);
		double lat2 = Math.toRadians(dois.latitude);
		double long2 = Math.toRadians(dois.latitude);
		double velMedJato = 805;
		int raioDaTerra = 6371;
		double d = 2*raioDaTerra*Math.asin(Math.sqrt(Math.sqrt(Math.sin((lat1 - lat2) / 2))+Math.sqrt(Math.sin((long1 - long2)/2))*Math.cos(lat1)*Math.cos(lat2)));
		return d;
	}

	@Override
	public String toString() {
		return "Geo [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
