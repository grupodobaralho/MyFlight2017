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

	public String toString() {
		return "Geo [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	public static double distancia(Geo local, Geo local2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
