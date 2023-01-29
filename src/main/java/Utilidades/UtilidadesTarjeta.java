package Utilidades;

public class UtilidadesTarjeta {
    public static int getCvv() {
        return (int) ((Math.random() * (1000 - 100))+100);
    }

    public static String getNumeroTarjeta() {

        int maxio = 10000;
        int minimo  = 1000;
        int NumberAleatorio1 = (int) ((Math.random() * (maxio - minimo)) +minimo );
        int NumberAleatorio2 = (int) ((Math.random() * (maxio - minimo)) +minimo );
        int NumberAleatorio3 = (int) ((Math.random() * (maxio - minimo)) +minimo );
        int NumberAleatorio4 = (int) ((Math.random() * (maxio - minimo)) +minimo );
        String NumeroTarjeta =  String.valueOf(NumberAleatorio1 +"-" + NumberAleatorio2 +"-" +NumberAleatorio3 +"-" +NumberAleatorio4);
        System.out.println(NumeroTarjeta);
        return NumeroTarjeta;
    }

}
