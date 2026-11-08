package com.mycompany.metricasjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidosTest {

    @Test
    public void testClienteVIP() {
        Pedidos pedidos = new Pedidos();
        int[] cantidades = {2};
        double[] precios = {10.0};
        assertEquals(18.0, pedidos.calcularTotal("VIP", cantidades, precios, false));
    }

    @Test
    public void testClienteFrecuente() {
        Pedidos pedidos = new Pedidos();
        int[] cantidades = {2};
        double[] precios = {10.0};
        assertEquals(19.0, pedidos.calcularTotal("FRECUENTE", cantidades, precios, false));
    }

    @Test
    public void testIgnoraItemsCantidadCero() {
        Pedidos pedidos = new Pedidos();
        int[] cantidades = {0};
        double[] precios = {50.0};
        assertEquals(0.0, pedidos.calcularTotal("NORMAL", cantidades, precios, false));
    }
    
    @Test
    public void testTotalMayorA100() {
        Pedidos pedidos = new Pedidos();
        int[] cantidades = {2};
        double[] precios = {60.0};
        assertEquals(115.0, pedidos.calcularTotal("NORMAL", cantidades, precios, false));
    }
    
    @Test
    public void testConCupon() {
        Pedidos pedidos = new Pedidos();
        int[] cantidades = {1};
        double[] precios = {50.0};
        assertEquals(45.0, pedidos.calcularTotal("NORMAL", cantidades, precios, true));
    }
    
    @Test
    public void testCalcularTotalTienda() {
        Pedidos pedidos = new Pedidos();
        int[] cantidades = {2};
        double[] precios = {10.0};
        assertEquals(18.0, pedidos.calcularTotalTienda("VIP", cantidades, precios));
    }
}
