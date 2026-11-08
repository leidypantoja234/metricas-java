package com.mycompany.metricasjava;

public class Pedidos {
    
    public double calcularTotal(String cliente, int[] cantidades, double[] precios, boolean cupon) {
        double total = calcularSubtotal(cantidades, precios);
        total = aplicarDescuentoCliente(total, cliente);
        
        if (total > 100 || cupon) {
            total -= 5;
        }
        return total;
    }

    public double calcularTotalTienda(String cliente, int[] cantidades, double[] precios) {
        double total = calcularSubtotal(cantidades, precios);
        return aplicarDescuentoCliente(total, cliente);
    }
    
    private double calcularSubtotal(int[] cantidades, double[] precios) {
        double subtotal = 0;
        for (int i = 0; i < cantidades.length; i++) {
            if (cantidades[i] > 0 && precios[i] > 0) {
                subtotal += cantidades[i] * precios[i];
            }
        }
        return subtotal;
    }
    
    private double aplicarDescuentoCliente(double monto, String cliente) {
        if ("VIP".equals(cliente)) {
            return monto * 0.9;
        } else if ("FRECUENTE".equals(cliente)) {
            return monto * 0.95;
        }
        return monto;
    }
}
