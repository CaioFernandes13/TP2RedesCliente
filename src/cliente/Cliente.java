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
        this.socket = new Socket(host, porta);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        String msg = "SOLICITACAO";
        output.writeUTF(msg);
        output.flush();
        this.id = input.readUTF();

    }

    public void enviarMensagem(String letra) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeUTF(letra);
        output.flush();
    }

    public Mensagem receberMensagem() throws IOException {
        Mensagem msg = new Mensagem();
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        String codigo = input.readUTF();
        msg.decodificarMensagem(codigo);
        return msg;
    }


}
