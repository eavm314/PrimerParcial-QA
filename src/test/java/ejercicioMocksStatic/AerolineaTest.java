package ejercicioMocksStatic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class AerolineaTest {
    private static MockedStatic<Aerolinea> aerolineaStatic;
    @BeforeAll
    public static void setup(){
        // Create Mock
        aerolineaStatic = Mockito.mockStatic(Aerolinea.class);
    }

    @ParameterizedTest
    @CsvSource({
            "32,1,2000",
            "32,3,2000",
            "31,4,2000",
            "32,7,2000",
            "32,8,2000",
            "31,9,2000",
            "32,10,2000",
            "31,11,2000",
            "32,12,2000",
            "30,2,2000",
            "29,2,2001",
            "-1,1,2000",
            "15,-1,2000",
            "1,11,-2000",
            "15,-11,-2000",
            "-1,-1,1937",
            "-15,1,-1937",
            "-1,-11,-1937",
            "0,-1,1937",
            "0,3,1937",
            "-1,-11,0",
            "0,0,0",
    })
    public void verificarFechasInvalidas(int dia, int mes, int gestion){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Aerolinea.reservarVuelo("dddd", 9999, dia, mes, gestion);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "La Paz, 10, true, 4,10,2023, Martes, el dia Martes 4 Octubre 2023 existen 10 pasajes para La Paz",
            "Oruro, 5, true, 4,8,2023, Martes, el dia Martes 4 Agosto 2023 existen 5 pasajes para Oruro",
            "Oruro, 1, true, 19,11,2023, Jueves, el dia Jueves 19 Noviembre 2023 existen 1 pasajes para Oruro",
            "Beni, 200, true, 4,12,2023, Sabado, el dia Sabado 4 Diciembre 2023 existen 200 pasajes para Oruro",
            "Beni, 5, true, 3,10,2023, Lunes, el dia Sabado 3 Octubre 2023 existen 5 pasajes para Oruro",
            "Beni, 200, true, 4,12,2023, Sabado, el dia Sabado 4 Diciembre 2023 existen 200 pasajes para Oruro",

    })
    public void verificarReservaVuelo(String destino, int cantidadPasajes, boolean resultadoExistenPasajes,
                                      int dia, int mes, int gestion, String diaSemana, String resultadoEsperado){

    }
}
