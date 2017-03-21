package pucrs.myflight.modelo;

public class Geo {
	@Override
	public String toString() {
		return "Geo [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

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
}
