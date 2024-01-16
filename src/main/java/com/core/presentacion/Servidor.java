package com.core.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
         private static final int serverPort = 3000;

        public static void main(String[] args) {
            try {
                ServerSocket serverSocket = null;
                try {
                    serverSocket = new ServerSocket(serverPort);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Servidor esperando conexiones en el puerto " + serverPort + "...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Cliente conectado desde " + clientSocket.getInetAddress().getHostAddress());

                    BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                    String clientRequest;
                    String serverResponse;

                    while ((clientRequest = input.readLine()) != null) {
                        System.out.println("Número de tarjeta de crédito recibido: " + clientRequest);

                        if (validarTarjetaCredito(clientRequest)) {
                            serverResponse = "Tarjeta de crédito válida";
                        } else {
                            serverResponse = "Tarjeta de crédito inválida";
                        }

                        output.println(serverResponse);
                    }

                    System.out.println("Cliente desconectado");
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static boolean validarTarjetaCredito(String numeroTarjeta) {


            return true;

    }
}
