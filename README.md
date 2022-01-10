###### Ejercicio Automatización WEB - LINIO

El proyecto se ha desarrollado usando Maven como gestor de
dependencias. El proyecto no concreta la venta debido a la
sensibilidad de datos.

**Requisitos previos:**
* Instalar IntelliJ.
* Tener instalado y configurado JVM.
* JDK 8 (Probado hasta la versión 11)
* Configurar el usuario y password del email en la línea 26 y 27 de la clase _/src/main/java/mail/MailSender_
* Si desea utilizar otro servidor de correo deberá configurarlo en las líneas 21 a 24 de la clase _/src/main/java/mail/MailSender_

**Pasos para la ejecución**:
1. Abrir el proyecto con IntelliJ
2. Abrir el archivo pom.xml y descargar las dependencias. (CTRL + MAYUSC + O)
3. Abrir la clase _src/test/java/pe/com/linio/RunTest.java_
4. Presione las teclas CTRL+Mayusc+F10 para ejecutar la clase _src/test/java/pe/com/linio/RunTest.java_
5. Luego de finalizar la ejecución, se crearán los reportes en la ruta _\wa-linio\reportes_. Existen 3 tipos de reportes:
   1. Formato HTML unificado que se genera desde CUCUMBER.
   2. Formato HTML con secciones generado por la dependencia monochromata
   3. Formato JSON
