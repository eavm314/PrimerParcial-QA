package ejercicioMocksStatic;

public class Aerolinea {
    public static String reservarVuelo(String destino, int cantidadPasajes, int dia, int mes, int gestion){
        if (cantidadPasajes<0){
            throw new IllegalArgumentException("La fecha proporcionada no es valida");
        }

        String diaSemana = getDay(dia, mes, gestion);
        String mesString = switch (mes) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octubre";
            case 11 -> "Noviembre";
            case 12 -> "Diciembre";
            default -> throw new IllegalStateException("Unexpected value: " + mes);
        };

        String fechaFormat = diaSemana+" "+dia+" "+mesString+" "+gestion;

        if (existenPasajes(destino, cantidadPasajes)){
            return "el dia "+fechaFormat+" existen "+cantidadPasajes+" pasajes para "+destino;
        } else {
            return "no existen suficientes pasajes para "+destino;
        }
    }

    public static boolean existenPasajes(String destino, int cantidad){
        return false;
    }

    public static String getDay(int dia, int mes, int gestion){
        return "Lunes";
    }
}
