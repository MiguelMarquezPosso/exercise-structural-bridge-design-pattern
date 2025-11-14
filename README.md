# Sistema de Encriptación con Patrón Bridge y Factory

## 📋 Descripción
Implementación de un sistema de encriptación que utiliza el patrón Bridge para desacoplar los algoritmos de cifrado del cliente, combinado con un Factory Method configurable que permite cambiar dinámicamente entre diferentes métodos de encriptación mediante archivos de propiedades.

## 🎯 Objetivo
Permitir que una aplicación se comunique con diferentes sistemas que requieren distintos métodos de cifrado, manteniendo la confidencialidad de la información y proporcionando versatilidad para cambios futuros sin modificar el código fuente.

## 🏗️ Patrones Implementados
### 🔗 Patrón Bridge
Abstracción: InterfaceMensajeEncriptacion
Implementación: InterfaceEncriptar
Puente: PuenteMensajeEncriptacion

### 🏭 Factory Method
Fábrica: BridgeFactory
Configuración: Archivo .properties

## 📁 Estructura del Proyecto

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
├── dockerfile                             # Configuración Docker
└── README.md

## ⚙️ Configuración
### 🔧 Archivo de Configuración
src/propiedades/BridgeConfig.properties:

### Configuración del algoritmo de encriptación
algoritmoEncriptacion=encriptacion.ProcesoEncriptarAES
#algoritmoEncriptacion=encriptacion.ProcesoEncriptarDES
#algoritmoEncriptacion=encriptacion.ProcesoSinEncriptar

### 🐳 Ejecución con Docker
docker build -t parcialbridge .
docker run parcialbridge

## 🎮 Uso
El sistema automáticamente:

✅ Lee la configuración del archivo .properties

✅ Crea el algoritmo de encriptación especificado

✅ Construye el Bridge con la implementación seleccionada

✅ Encripta el mensaje usando el método configurado

## 🔄 Cambio de Algoritmo
Para cambiar el algoritmo de encriptación, simplemente edita el archivo BridgeConfig.properties y modifica la línea:
algoritmoEncriptacion=encriptacion.ProcesoEncriptarDES
