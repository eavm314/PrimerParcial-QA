package ejercicioUnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "-999999",
                    "-100.5",
                    "-1",
                    "-0.1",
            }
    )
    public void testSalarioNoValido(double salario){
        SalarioClass slr = new SalarioClass();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            slr.calcularDescuento(salario);
        });
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "0,0",
                    "1,1",
                    "1000,1000",
                    "2000,2000",
                    "2001,1900.95",
                    "2100,1995",
                    "3500,3325",
                    "3999.91,3799.91",
                    "4000,3800",
                    "4001,3600.9",
                    "5000,4500",
                    "100000,90000",
                    "1000000.5,900000.45",
                    "42123.3,37910.97",
            }
    )
    public void testCalcularDescuento(double salario, double descuentoEsperado){
        SalarioClass slr = new SalarioClass();
        double descuentoActual = slr.calcularDescuento(salario);

        Assertions.assertEquals(descuentoEsperado, descuentoActual, "Error, el resultado no es el esperado");
    }
}
