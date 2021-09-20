package rs.ac.bg.fon.ai.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.ai.transkript.KlijentskiZahtev;
import rs.ac.bg.fon.ai.transkript.ServerskiOdgovor;

public class KomunikacijaSaServerom {
	private static KomunikacijaSaServerom instance;
    Socket s;

    private KomunikacijaSaServerom() {
        try {
            s = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static KomunikacijaSaServerom getInstance() {
        if (instance == null) {
            instance = new KomunikacijaSaServerom();
        }
        return instance;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(kz);
        } catch (IOException ex) {
            System.out.println("Greska (out) posalji Zahtev komunikacija sa serverom");
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ServerskiOdgovor primiOdgovor() {

        try {
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            return (ServerskiOdgovor) in.readObject();
        } catch (IOException ex) {
            System.out.println("Greska (in) primi Odgovor komunikacija sa serverom");

            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Greska (in) primi Odgovor komunikacija sa serverom prilikomcitanja odg");

            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
