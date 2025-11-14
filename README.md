# Sistema de Encriptación con Patrón Bridge y Factory

## 📋 Descripción
Implementación de un sistema de encriptación empresarial que utiliza el patrón Bridge para desacoplar los algoritmos de cifrado del cliente, combinado con un Factory Method configurable que permite cambiar dinámicamente entre diferentes métodos de encriptación mediante archivos de propiedades.

## 🎯 Objetivo
Permitir que una aplicación se comunique con diferentes sistemas que requieren distintos métodos de cifrado, manteniendo la confidencialidad de la información y proporcionando versatilidad para cambios futuros sin modificar el código fuente.

## 🏗️ Patrones Implementados

### 🔗 Patrón Bridge
Interfaz: InterfaceEncriptar

Abstracción: InterfaceMensajeEncriptacion

Implementaciones: ProcesoEncriptarAES, ProcesoEncriptarDES, ProcesoSinEncriptar

Puente: PuenteMensajeEncriptacion

### 🏭 Factory Method
Fábrica: BridgeFactory

Configuración: BridgeConfig.properties

Selección: Algoritmo definido en configuración

## 📁 Estructura del Proyecto
```
ParcialBridge/
├── src/
│   ├── bridge/
│   │   └── PatronBridgeMain.java          # Clase principal
│   ├── encriptacion/                      # Implementaciones de encriptación
│   │   ├── InterfaceEncriptar.java        # Interface común
│   │   ├── ProcesoEncriptarAES.java       # Algoritmo AES
│   │   ├── ProcesoEncriptarDES.java       # Algoritmo DES
│   │   └── ProcesoSinEncriptar.java       # Sin encriptación
│   ├── factory/
│   │   └── BridgeFactory.java             # Factory configurable
│   ├── implementacion/                    # Patrón Bridge
│   │   ├── InterfaceMensajeEncriptacion.java
│   │   └── PuenteMensajeEncriptacion.java
│   ├── propiedades/
│   │   └── BridgeConfig.properties        # Configuración
│   └── utilidades/
│       └── UtilidadesAcceso.java          # Utilidades para propiedades
└── dockerfile                             # Configuración Docker
```

## ⚙️ Configuración

### 🔧 Archivo de Configuración
src/propiedades/BridgeConfig.properties:

```
algoritmoEncriptacion=encriptacion.ProcesoEncriptarAES

#algoritmoEncriptacion=encriptacion.ProcesoEncriptarDES

#algoritmoEncriptacion=encriptacion.ProcesoSinEncriptar
```

## 🐳 Ejecución con Docker
```
docker build -t parcialbridge .

docker run parcialbridge
```

## 🎮 Uso
El sistema automáticamente ejecuta pruebas que demuestran

**Bridge con AES**:
```
InterfaceMensajeEncriptacion bridge = BridgeFactory.createBridge();
String mensaje = bridge.EncryptarMensaje("mensaje", "clave");
// Resultado: Mensaje encriptado con AES
```

**Bridge con DES**:
```
// Cambiar propiedad: algoritmoEncriptacion=encriptacion.ProcesoEncriptarDES
InterfaceMensajeEncriptacion bridge = BridgeFactory.createBridge();
String mensaje = bridge.EncryptarMensaje("mensaje", "clave");  
// Resultado: Mensaje encriptado con DES
```

**Bridge sin Encriptación**:
```
// Cambiar propiedad: algoritmoEncriptacion=encriptacion.ProcesoSinEncriptar
InterfaceMensajeEncriptacion bridge = BridgeFactory.createBridge();
String mensaje = bridge.EncryptarMensaje("mensaje", "clave");
// Resultado: Mensaje original sin cambios
```

## 🔄 Cambio de Comportamiento

Para cambiar el algoritmo de encriptación, simplemente modifica el archivo de propiedades:
```
# Para usar AES
algoritmoEncriptacion=encriptacion.ProcesoEncriptarAES

# Para usar DES  
algoritmoEncriptacion=encriptacion.ProcesoEncriptarDES

# Para sin encriptación
algoritmoEncriptacion=encriptacion.ProcesoSinEncriptar
```

## 🔐 Flujo de Ejecución

1. Cliente solicita encriptación al Factory

2. Factory lee configuración del archivo .properties

3. Factory crea implementación específica (AES/DES/None)

4. Factory construye Bridge con la implementación

5. Bridge delega encriptación a la implementación concreta

6. Cliente recibe mensaje encriptado sin conocer el algoritmo

