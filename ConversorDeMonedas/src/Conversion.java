import com.google.gson.annotations.SerializedName;

import java.io.IOException;

public class Conversion {
    final String dolar = "USD";
    final String pesoArgentino = "ARS";
    final String realBrasileno = "BRL";
    final String pesoColombiano ="COP";
    private String conversion;



    public String getConversion(int opcion) {
        if (opcion == 1){
            conversion = dolar + "/" + pesoArgentino;
        } else if (opcion == 2) {
            conversion = pesoArgentino + "/" + dolar;
            return conversion;
        }else if (opcion == 3) {
            conversion = dolar + "/" + realBrasileno;
        } else if (opcion == 4) {
            conversion = realBrasileno + "/" + dolar;
        } else if (opcion == 5) {
            conversion = dolar + "/" + pesoColombiano;
        } else if (opcion == 6) {
            conversion = pesoColombiano + "/" + dolar;
        }else{
            conversion = conversion;
        }
        return conversion;

    }

}
