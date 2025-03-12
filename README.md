# Tarea 3.- Desarrollo de una Aplicación Móvil Nativa con Consumo de API REST

## Ejercicio 1: Creación de un Backend Básico y Conexión con Android

Este proyecto implementa un backend básico con Node.js y Express, permitiendo la conexión desde cualquier dispositivo que conozca la IP del servidor. Esto facilita la integración con una aplicación móvil desarrollada en Android Studio utilizando Retrofit para realizar solicitudes HTTP.

### 🛠️ Tecnologías Utilizadas

- 🟢 Node.js
- 🚀 Express.js
- 🔓 CORS (Permite conexiones externas)
- 📄 dotenv (Gestiona variables de entorno)

### 🚀 Ejecución

1. Verificar que Node.js esté instalado en tu sistema mediante _node -v_.
2. Instala las dependencias del proyecto con _npm install_.
3. Inicia el servidor ejecutando _node server.js_

Esto pondrá el backend en marcha y estará disponible en **http://localhost:4000/** en la máquina que lo ejecuta.

### 🚧 Desafíos del Proyecto

Uno de los mayores desafíos en este proyecto fue conectar la aplicación en Kotlin con el backend en Node.js y Express. Para lograrlo, fue necesario realizar algunas configuraciones adicionales en el AndroidManifest.xml, principalmente habilitar las siguientes opciones:

    <application
        android:usesCleartextTraffic="true"
        android:networkSecurityConfig="@xml/network_security_config">
    </application>

Android, por defecto, bloquea las conexiones HTTP sin cifrar (Cleartext Traffic), lo que impide la comunicación con un backend alojado en una IP local. La opción android:usesCleartextTraffic="true" permite estas conexiones.**_network_security_config_** es un archivo XML donde especificamos las direcciones IP o dominios que pueden realizar conexiones sin cifrado. En este caso, configuramos la dirección IP de nuestra máquina host para permitir la comunicación con el servidor.

## Ejercicio 2: Consumo de una API Pública

Este proyecto implementa una aplicación móvil desarrollada en Kotlin con Android Studio, que consume la API pública de OpenWeatherMap para obtener información meteorológica. La comunicación con la API se realiza mediante Retrofit para gestionar las solicitudes HTTP.

### 🛠️Tecnologías Utilizadas

- 🤖 Kotlin (Lenguaje principal de la app)
- 📡 Retrofit 2 (Para realizar las solicitudes HTTP)
- 🛠️ OkHttp (Para depuración de llamadas HTTP)
- 🔄 Coroutines (Para manejar llamadas asíncronas)
- 🌤️ OpenWeatherMap API (Fuente de datos climáticos)

### 🚀Ejecución

1. Configurar API Key

Antes de ejecutar la aplicación, necesitas una clave de API de OpenWeatherMap.

- Regístrate en OpenWeatherMap.
- Copia tu API Key desde la sección API Keys.
- Reemplaza "TU_API_KEY_AQUI" en MainActivity.kt con tu clave real:

  val apiKey = "TU_API_KEY_AQUI"

### 🚧Desafíos del Proyecto

Uno de los principales desafíos en esta aplicación fue configurar correctamente Retrofit y manejar los permisos de red en Android. Para permitir las solicitudes HTTP, fue necesario agregar el permiso de Internet en AndroidManifest.xml:

    <uses-permission android:name="android.permission.INTERNET"/>

Android, por defecto, bloquea conexiones HTTP sin cifrar, por lo que OpenWeatherMap requiere HTTPS. Afortunadamente, la API ya usa **https://**, lo que evitó la necesidad de configuraciones adicionales en network_security_config.xml.
