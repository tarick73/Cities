package cities;

public class Cities10k {
    public String name="";
    public double latitude=0.0;
    public double longitude=0.0;

    public Cities10k(String _name, double _latitude, int _longitude) {
        name = _name;
        latitude = _latitude;
        longitude = _longitude;
    }
    public Cities10k() {
    }
    public static double Calculations(String nameX,double latitudeX, double longitudeX,String nameY, double latitudeY, double longitudeY){
        double result;
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(latitudeY- latitudeX);
        double dLon = Math.toRadians(longitudeY - longitudeX);

        // convert to radians
        latitudeX = Math.toRadians(latitudeX);
        latitudeY = Math.toRadians(latitudeY);

        // apply formula
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(latitudeX) *
                        Math.cos(latitudeY);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        result= rad * c;
        return result;
    }
//    public static class Result{
//        public double distance;
//        public String nameA, nameB;
//    }
}