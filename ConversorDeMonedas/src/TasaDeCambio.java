public class TasaDeCambio {
    private String base_code;  // Asegúrate de que el nombre coincida con el JSON
    private String target_code;  // Asegúrate de que el nombre coincida con el JSON
    private double conversion_rate;  // Asegúrate de que el nombre coincida con el JSON

    public String getBaseCode() {
        return base_code;
    }

    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }

    public String getTargetCode() {
        return target_code;
    }

    public void setTargetCode(String target_code) {
        this.target_code = target_code;
    }

    public double getConversionRate() {
        return conversion_rate;
    }

    public void setConversionRate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    @Override
    public String toString() {
        return "TasaDeCambio{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                '}';
    }
}
