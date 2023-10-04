package ejercicioUnitTest;

public class SalarioClass {
    public static final int SALARIO_MINIMO = 2000;

    public double calcularDescuento(double salario) throws IllegalArgumentException{
        if (salario < 0){
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }

        if (salario <= SALARIO_MINIMO){
            return salario;
        } else if (salario <= 2*SALARIO_MINIMO){
            return Math.round(salario * 95)/100.0;
        } else {
            return Math.round(salario * 90)/100.0;
        }
    }
}
