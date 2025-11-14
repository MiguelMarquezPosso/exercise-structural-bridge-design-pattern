FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar todos los archivos fuente
COPY src /app/src

# Compilar todos los archivos Java
RUN find src -name "*.java" > sources.txt && \
    javac -d . @sources.txt

# Crear directorio propiedades en el classpath y copiar el archivo
RUN mkdir -p propiedades
COPY src/propiedades/BridgeConfig.properties propiedades/

# Verificar que los archivos están en su lugar
RUN echo "=== Estructura de archivos ===" && \
    find . -name "*.class" | head -5 && \
    echo "=== Archivo de propiedades ===" && \
    ls -la propiedades/BridgeConfig.properties && \
    cat propiedades/BridgeConfig.properties

CMD ["java", "-cp", ".", "bridge.PatronBridgeMain"]