package factory;

import encriptacion.InterfaceEncriptar;
import implementacion.InterfaceMensajeEncriptacion;
import implementacion.PuenteMensajeEncriptacion;
import utilidades.UtilidadesAcceso;

import java.util.Properties;

public class BridgeFactory {

    public BridgeFactory() {}

    public static InterfaceMensajeEncriptacion createBridge() {
        Properties props = UtilidadesAcceso.loadProperty(
                "propiedades/BridgeConfig.properties");
        String algoritmoClass =
                props.getProperty("algoritmoEncriptacion");
        try {
            InterfaceEncriptar algoritmo = (InterfaceEncriptar)
                    Class.forName(algoritmoClass).newInstance();
            return new PuenteMensajeEncriptacion(algoritmo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}