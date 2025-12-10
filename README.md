# 📱 Contador Jetpack Compose

Este proyecto es una aplicación simple desarrollada en *Kotlin* usando
*Jetpack Compose*, que implementa un contador con varias
funcionalidades: sumar, restar, mostrar errores, contar pulsaciones y
reiniciar los valores.

------------------------------------------------------------------------

## 🚀 Características principales

-   ✔ *Sumar y restar 1*
-   ✔ *Sumar y restar 5*
-   ✔ *Control de errores*:
    -   No permite restar por debajo de 0
    -   Mensajes de advertencia visibles en pantalla
-   ✔ *Contador total de pulsaciones* realizadas en la app
-   ✔ *Botón de reinicio* que limpia todos los valores
-   ✔ *Imagen de fondo* ocupando toda la pantalla
-   ✔ Interfaz creada completamente con *Jetpack Compose*

------------------------------------------------------------------------

## 🧱 Estructura del proyecto

### MainActivity

-   Inicializa la app usando setContent y la temática ContadorTheme.
-   Usa Scaffold para manejar el layout base.
-   Llama al composable principal Count().

### Count()

Es el composable principal donde se encuentra toda la lógica y UI:

#### 🔹 Estado utilizado

-   count: contador principal
-   count2: contador total de pulsaciones
-   messageError: mensaje de error mostrado cuando no se puede restar
-   Imagen de fondo con Image() y ContentScale.Crop

#### 🔹 Elementos de la UI

-   *Mensajes de error* en un Box rojo
-   *Contador principal* centrado en pantalla
-   *Botones de sumar y restar 1*
-   *Botones de sumar y restar 5*
-   *Contador total de pulsaciones*
-   *Botón "Borrar"* con borde rojo

------------------------------------------------------------------------

## 🖼 Vista previa

Incluye un @Preview para visualizar la UI dentro de Android Studio.

------------------------------------------------------------------------

## 📂 Recursos necesarios

Asegúrate de incluir una imagen en:

    res/drawable/imagen_fondo.png

------------------------------------------------------------------------

## ▶ Cómo ejecutar

1.  Clona o copia el proyecto en Android Studio.
2.  Asegúrate de tener *Compose habilitado* y la dependencia Material3
    instalada.
3.  Ejecuta la app en un emulador o dispositivo físico.

------------------------------------------------------------------------

## 💡 Posibles mejoras

-   Añadir animaciones a los botones
-   Agregar un historial de operaciones
-   Guardar los datos en DataStore
-   Añadir temas dinámicos

------------------------------------------------------------------------

## 📜 Licencia

Este proyecto puede ser utilizado para fines educativos o personales sin
restricciones.

------------------------------------------------------------------------