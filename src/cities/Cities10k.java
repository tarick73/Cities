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
    public static Object[] Calculations(Cities10k cityX, Cities10k cityY){
        double result;
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(cityY.latitude - cityX.latitude);
        double dLon = Math.toRadians(cityY.longitude - cityX.longitude);

        // convert to radians
        cityX.latitude = Math.toRadians(cityX.latitude);
        cityY.latitude = Math.toRadians(cityY.latitude);

        // apply formula
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(cityX.latitude) *
                        Math.cos(cityY.latitude);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        result= rad * c;
        Object[] res = new Object[3];
        res[0] = result;
        res[1] = cityX.name;
        res[2] = cityY.name;
        return res;
    }
}
