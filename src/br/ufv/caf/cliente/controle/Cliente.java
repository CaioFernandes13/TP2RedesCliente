package br.ufv.caf.cliente.controle;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    boolean habilitado = false;
    PrintStream output;
    Socket cliente;
    Servidor servidor;
    Thread threadServidor;

    public Cliente(Socket cliente) throws IOException {
        this.cliente = cliente;
        this.servidor = new Servidor(cliente.getInputStream());
        this.threadServidor = new Thread(this.servidor);
        output = new PrintStream(this.cliente.getOutputStream());
    }

    public void executa() throws UnknownHostException, IOException {
        this.threadServidor.start();
    }

    public String enviarMensagem(String msg) throws IOException {
            this.output.println(msg);
            this.output.flush();
            return servidor.getMensagemServidor();

    }

    public String receberMensagem() {
        return servidor.getMensagemServidor();
    }
}

class Servidor implements Runnable {

    private final InputStream servidor;
    private String msg = "";

    public Servidor(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            setMsg(s.nextLine());
            System.out.println(msg);
        }
    }

    public String getMensagemServidor() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
