package bridge;

import factory.BridgeFactory;
import implementacion.InterfaceMensajeEncriptacion;

public class PatronBridgeMain {

    public static void main(String[] args) {
        // Crear el bridge mediante el factory basado en configuración
        InterfaceMensajeEncriptacion bridge = BridgeFactory.createBridge();

        try {
            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String encryptedMessage = bridge.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Mensaje encriptado > " + encryptedMessage + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
