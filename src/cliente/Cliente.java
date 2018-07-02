package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import modelo.Mensagem;

public class Cliente {

    Socket socket;
    String id;

    public Cliente() {

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void conectarCliente(String host, int porta) throws IOException {
        System.out.println("conectar cliente...");
        this.socket = new Socket(host, porta);
        System.out.println("cliente conectado");
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        String msg = "SOLICITACAO";
        output.writeUTF(msg);
        System.out.println("Mensagem enviada: " + msg);
        output.flush();
        this.id = input.readUTF();
        System.out.println("Mensagem recebida: " + this.id);

    }

    public void enviarMensagem(String letra) throws IOException {
        System.out.println("Enviando Mensagem...");
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeUTF(letra);
        System.out.println("Mensagem : " + letra + " enviada.");
        output.flush();
    }

    public Mensagem receberMensagem() throws IOException {
        System.out.println("Recebendo Mensagem...");
        Mensagem msg = new Mensagem();
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        String codigo = input.readUTF();
        System.out.println("Mensagem :" + codigo + " Recebido.");
        msg.decodificarMensagem(codigo);
        return msg;
    }


}
