package ar.edu.unlp.oo1.ejercicio20_PoliticasDeCancelacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;

import java.time.LocalDate;

class PoliticasDeCancelacionTest {

    private Usuario usuario;
    private Inmueble inmuebleFlexible;
    private Inmueble inmuebleModerado;
    private Inmueble inmuebleEstricta;
    private DateLapse periodoReserva; // del 10 al 15 de octubre (5 días)

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Ana", "Dir", "123");
        inmuebleFlexible = new Inmueble("Calle F", "Depto Flexible", 100.0, new Flexible());
        inmuebleModerado = new Inmueble("Calle M", "Depto Moderado", 100.0, new Moderada());
        inmuebleEstricta = new Inmueble("Calle E", "Depto Estricto", 100.0, new Estricta());
        periodoReserva = new DateLapse(LocalDate.of(2024, 10, 10), LocalDate.of(2024, 10, 15));
    }

    @Test
    void testFlexibleReembolsaTotal() {
        Reserva r = new Reserva(usuario, inmuebleFlexible, periodoReserva);
        inmuebleFlexible.agregarReserva(r);

        double reembolso = inmuebleFlexible.cancelarReserva(r);
        assertEquals(500.0, reembolso); // 5 días × 100
    }

    @Test
    void testModeradaMasDe7DiasAntes() {
        // Fecha actual simulada más de 7 días antes del inicio
        DateLapse periodo = new DateLapse(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));
        Reserva r = new Reserva(usuario, inmuebleModerado, periodo);

        double reembolso = inmuebleModerado.cancelarReserva(r);
        assertEquals(500.0, reembolso);
    }

    @Test
    void testModeradaEntre2y7Dias() {
        // Cancelación entre 2 y 7 días antes
        DateLapse periodo = new DateLapse(LocalDate.now().plusDays(3), LocalDate.now().plusDays(8));
        Reserva r = new Reserva(usuario, inmuebleModerado, periodo);

        double reembolso = inmuebleModerado.cancelarReserva(r);
        assertEquals(250.0, reembolso); // mitad del precio total
    }

    @Test
    void testModeradaMenosDe2Dias() {
        // Cancelación a menos de 2 días del inicio
        DateLapse periodo = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(6));
        Reserva r = new Reserva(usuario, inmuebleModerado, periodo);

        double reembolso = inmuebleModerado.cancelarReserva(r);
        assertEquals(0.0, reembolso);
    }

    @Test
    void testEstrictaSinReembolso() {
        Reserva r = new Reserva(usuario, inmuebleEstricta, periodoReserva);
        inmuebleEstricta.agregarReserva(r);

        double reembolso = inmuebleEstricta.cancelarReserva(r);
        assertEquals(0.0, reembolso);
    }
}
