import contrato.Contrato;
import contrato.ContratoFullTime;
import empleado.Empleado;
import empleado.Sexo;
import licencia.*;
import politicaDiasPorLicencia.Hermano;
import politicaDiasPorLicencia.Nieto;
import politicaDiasPorLicencia.PoliticaDiasPorLicencia;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("************************************************");
        System.out.println("**PRUEBAS SOBRE LA LICENCIA POR DIA DE ESTUDIO**");
        System.out.println("************************************************");

        LocalDate fechaInicio = LocalDate.of(2024,9,3);
        LocalDate fechaFin = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);

        Contrato contratoKate = new ContratoFullTime(500000);
        LocalDate fechaIngreso = LocalDate.of(2022,3,7);

        Empleado kate = new Empleado("katerina cejas",
                                    41824075, contratoKate,
                                        fechaIngreso, Sexo.FEMENINO);

        System.out.println(kate.tomarLicencia(licenciaDiaEstudio));

        LocalDate fechaInicio2 = LocalDate.of(2024,9,3);
        LocalDate fechaFin2 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio2 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio2));

        LocalDate fechaInicio3 = LocalDate.of(2024,9,3);
        LocalDate fechaFin3 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio3 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio3));

        LocalDate fechaInicio4 = LocalDate.of(2024,9,3);
        LocalDate fechaFin4 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio4 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio4));

        LocalDate fechaInicio5 = LocalDate.of(2024,9,3);
        LocalDate fechaFin5 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio5 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio5));

        LocalDate fechaInicio6 = LocalDate.of(2024,9,3);
        LocalDate fechaFin6 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio6 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio6));

        LocalDate fechaInicio7 = LocalDate.of(2024,9,3);
        LocalDate fechaFin7 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio7 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio7));

        LocalDate fechaInicio8 = LocalDate.of(2024,9,3);
        LocalDate fechaFin8 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio8 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio8));

        LocalDate fechaInicio9 = LocalDate.of(2024,9,3);
        LocalDate fechaFin9 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio9 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio9));

        LocalDate fechaInicio10 = LocalDate.of(2024,9,3);
        LocalDate fechaFin10 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio10 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio10));

        // esta licencia ya no debería permitir tomarla, las anteriores si
        LocalDate fechaInicio11 = LocalDate.of(2024,9,3);
        LocalDate fechaFin11 = LocalDate.of(2024, 9, 4);
        Licencia licenciaDiaEstudio11 = new LicenciaPorDiaDeEstudio(fechaInicio, fechaFin);
        System.out.println(kate.tomarLicencia(licenciaDiaEstudio11));

        System.out.println("************************************************");
        System.out.println("****PRUEBAS SOBRE LA LICENCIA POR ENFERMEDAD****");
        System.out.println("************************************************");

        Empleado kate2 = new Empleado("katerina cejas",
                41824075, contratoKate,
                LocalDate.of(2010,4,5), Sexo.FEMENINO);

        Licencia licenciaPorenfermedad = new LicenciaPorEnfermedad(LocalDate.of(2024,1,1),
                                        LocalDate.of(2024,2,2));

        //esta licencia debe permitir tomarla. kate2 tiene mas de 5 años de antiguedad y pide menos de 3 meses de licencia
        System.out.println(kate2.tomarLicencia(licenciaPorenfermedad));

        Licencia licenciaPorenfermedad2 = new LicenciaPorEnfermedad(LocalDate.of(2024,1,1),
                LocalDate.of(2024,9,9));

        //esta licencia no debe permitir tomarla. kate2 tiene mas de 5 años de antiguedad y pide mas de 3 meses de licencia
        System.out.println(kate2.tomarLicencia(licenciaPorenfermedad2));

        System.out.println("************************************************");
        System.out.println("**PRUEBAS SOBRE LA LICENCIA POR FALLECIMIENTO***");
        System.out.println("************************************************");

        PoliticaDiasPorLicencia parienteFallecido = new Hermano();
        Licencia licenciaPorFallecimiento = new LicenciaPorFallecimiento(
                LocalDate.of(2024,1,1),
                LocalDate.of(2024,1,3),
                parienteFallecido
        );

        //esta licencia debe permitir tomarla. La licencia es por 2 dias y es menor a los dias por hermano
        System.out.println(kate2.tomarLicencia(licenciaPorFallecimiento));

        PoliticaDiasPorLicencia parienteFallecido2 = new Nieto();
        Licencia licenciaPorFallecimiento2 = new LicenciaPorFallecimiento(
                LocalDate.of(2024,1,1),
                LocalDate.of(2024,1,3),
                parienteFallecido2
        );

        //esta licencia no debe permitir tomarla. La licencia es por 2 dias y es mayor a el unico dia permitido por nieto
        System.out.println(kate2.tomarLicencia(licenciaPorFallecimiento2));

        System.out.println("************************************************");
        System.out.println("****PRUEBAS SOBRE LA LICENCIA POR NACIMIENTO****");
        System.out.println("************************************************");

        Licencia licenciaPorNacimiento = new LicenciaPorNacimiento(
                LocalDate.of(2024,1,1),
                LocalDate.of(2024,5,5)
        );

        //esta licencia no debe permitir tenerla, porque es una licencia por mas dias de los permitidos por el sexo femenino
        System.out.println(kate2.tomarLicencia(licenciaPorNacimiento));

        Licencia licenciaPorNacimiento2 = new LicenciaPorNacimiento(
                LocalDate.of(2024,1,1),
                LocalDate.of(2024,1,3)
        );

        Empleado hombre = new Empleado("nombre apellido",
                41824075, contratoKate,
                fechaIngreso, Sexo.MASCULINO);

        //esta licencia si debe permitir tomarla porque pide licencia de 2 dias que es lo mismo que la maxima cantidad de dias que se da al sexo masculino
        System.out.println(hombre.tomarLicencia(licenciaPorNacimiento2));
    }
}