***
![image](https://user-images.githubusercontent.com/110683543/186949077-f98d74be-cad2-4b61-8096-acfaa3272547.png)
***
# **🗃️Tabla de contenido**.
1. [Introduccion.](#Introduccion)
2. [Resumen.](#Resumen)
3. [Planteamiento del problema.](#Planteamientodelproblema)

      3.1.[Descripcion del problema.](#Descripciondelproblema)
  
4. [Objetivos.](#Objetivos)

      4.1.[Objetivo General.](#Objetivo_General)
      
      4.2.[Objetivos Especificos.](#Objetivos_Especificos)
      
5. [Justificacion.](#Justificacion)
6. [Desarollo Ingenieril.](#Desarollo_Ingenieril)

      6.1. [Descripcion tecnica del sistema.](#Descripcion_tecnica_del_sistema)
      
      6.2. [Diseño de Interfaz.](#Diseño_de_Interfaz)
      
7. [Conclusiones.](#Conclusiones)

***
## **💡Introduccion.** 
En el presente documento encontraremos lo que sería como fue que surgió la necesidad de un software de transacciones, dando énfasis a problemas de la cotidianidad y de porque es requerido un sistema de este tipo, planteamos objetivos que tiene este software para brindarles a las personas de la cooperativa, se evidencia como fue el paso a paso para la realización de la interfaz, a lo cual realizamos modelados, requerimientos e investigaciones hacerla de leyes basadas en transacciones y la seguridad de los datos personales.
***
## **📝Resumen.**
El software quiere solucionar los problemas que tiene la gente con algunas identidades bancares ya sea por temas de ahorro, retiro o tracción, de la misma forma encontrara sus objetivos para poder solucionar dichos problemas. Además, para poder complementar y mejorar la construcción de este software, se es necesario el estudio de varios campos como metodologías, técnicas de información, estudios previos y conocimientos no visto, se mostrará los gastos que genera el proyecto, se realizará bosquejos de interfaz, un modelado de diagramas de clase y diagrama de casos de uso que requerirán sus requisitos funcionales, y al finalizar se concluirá todo el contenido.
***
## **📄Planteamiento del problema.** 
***
### 🖋️Descripcion de Problematica.
La problemática que se vive hoy en día es, que la mayoría de los estudiantes, maestro o personas de la comunidad, les cobran valores extra de dinero ya sea para retirar, transferir, y meter dinero en las cuentas de ellos, esto teniendo un límite de tiempo para el almacenamiento del dinero y llegando a pagar pequeños porcentajes a la identidad bancaria. Por lo tanto, esto demuestra la incomodidad de mini pagos por hacer un movimiento con el dinero, ya que se sale gasta más de lo que va a ahorrar o retirar.
***
## **🗄️Objetivos.** 
***
### 🏷️Objetivo General.
El objetivo principal de nuestro sistema es crear un sistema de cooperativa moderno que facilite a los estudiantes, maestros o personas de la comunidad, a hacer un ahorro económico, también puedan transferir dinero, ingresar dinero o retirar el mismo que se va a ahorrar, permitiendo a los usuarios ver un registro de los movimientos de la cuenta dando información o recibos que contiene el tipo de movimiento que hizo en la cuenta, la fecha y hora que se realizó su acción. Asimismo, también tiene acceso para los administradores que tienen el fin de modificar, agregar o eliminar usuarios ya existentes en el sistema.
### 🔎Objetivos Especificos.
Nuestro proyecto/sistema tiene como objetivo:

✅ Brindar un nuevo sistema más cómodo y moderno para las personas.

✅ El usuario no tendrá contacto directo con la base de datos.

✅ Mejorar la información de cada transacción realizada por el usuario.

✅ Cambiar el enfoque de los sistemas de transacciones a nuestro favor. 

✅ Ser un buen sistema de transacciones bancarias.

✅ Extender nuestro sistema y ser reconocidos nacional e internacionalmente. 

✅ Distinguir notoriamente de las demás proyectos y sistemas.

✅ Generar satisfacción en todas las necesidades del cliente y usuario.

✅ Actualizar el proyecto y mejorar a medida que aumente su popularidad.

***
## **▶️Justificacion.** 
***
 Una de las cualidades importante que tiene el proyecto es el fácil uso que tiene al manejarlos, genera beneficios tanto a los clientes como a los labradores, con esto quiere decir que se puede generar ganancias por habilidad más capacidad de ahorro en la cuenta, por ejemplo: el cliente tiene capacidad y ahorrar 10.000.000 de pesos, el cual quedara hasta ese monto para poder ingresar más dinero, entonces el usuario deberá pagar un pequeño costo para aumentar la capacidad de ahorro ya se a 20 o 30 millones. En base a los diferentes beneficios que puede atraer a los dos bandos los cuales son:
 
 🟪 Seguridad de datos personales.
 
 🟪 No cobra costos adicionales al hacer un movimiento. (Solo se cobrar el aumento de capacidad de al depositar el dinero que van a ahorrar).
 
 🟪 Fácil acceso a los usuarios.
 
 🟪 Interacción más rápida en los menús.
 
 🟪 Equipo de soporte para modificar los datos personales.
 
 🟪 Puede llevar un ahorro diario.
 
 
Lo que se espera del software es:
 
 🟦 Fácil de usar.
 
 🟦 No tenga muchos costos adicionales.
 
 🟦 Sea seguro, util y comodo para los usuarios.
 
 🟦 El manejo de administrativo sea optimo, eficiente y confiable.
 
 ***
##  **👨‍💻Desarollo Ingenieril.**
 ***
###  **▶️Descripcion tecnica del sistema.**
Este sistema recibe el nombre de Sistema Bancario Transfercoop, el cual está construida en lenguaje JAVA, del cual se utilizaron las interfaces gráficas, dentro de la lógica desarrollada para este sistema consiste en la utilización de dos tipos de usuarios, los cuales tiene diferentes niveles de acceso, teniendo distintos privilegios y roles.

**📌Administrador:** Este rol es el más alto de los dos ya que tiene acceso a toda la información que hay en la base de datos pudiendo conocer todos los datos de los demás usuarios de los cuales pude modificar su información como los son, nombre apellido, contraseña y rango.

**📌Usuario final:** En este rol, se puede hacer las operación o transacciones que el usuario decida, los cuales son agregar o retirar dinero, transferir dinero, consultar sus movimientos e imprimir recibo.

**📌Base de Datos:** Esta esta creada en “MYSQL community server”, en la cual se crearon dos tablas.

**📌Tabla de Usuarios:** En esta tabla se almacenaron los datos del usuario los cuales son Nombre, Apellido, Numero de ID, Genero, contraseñe y dinero.

**📌Tabla de Movimientos:** Esta tabla almacena todos los movimientos de los usuarios, y tiene las columnas donde se almacenan los siguientes datos, Numero de ID, Numero de ID destinatario, Fecha y Hora, Acción, Monto.

**📌Como se obtienen los datos del usuario:** Al usuario registrar sus datos en Login los cuales son Numero de ID y Contraseñas, estos datos se buscan en la base de datos para comprobar si existe un usuario con las misma Contraseña e Numero de ID, para que pueda concederle el acceso al sistema, y sacando de la base de datos solo la información del usuario ingresado, esta información es utilizada poder hacer diferentes operaciones.

 ***
 ## **📲Diseño de Interfaz.**
 ***
 #### Bosquejos antiguos.
 ***
 ![image](https://user-images.githubusercontent.com/110683543/187016882-16850632-bd57-4cc8-995d-19cf4b48c021.png)
 ***
 ![image](https://user-images.githubusercontent.com/110683543/187016943-dee4c9d9-214e-492c-96c2-8f7d1cc58a01.png)
 ***
 ![image](https://user-images.githubusercontent.com/110683543/187016958-84b3ca1e-b500-4f73-a331-3ec9a63ccf21.png)
 ***
 ![image](https://user-images.githubusercontent.com/110683543/187016970-db61c640-37a4-4346-8300-34f025419cd6.png)
 ***
 ## **📋Conclusiones.**
 ***
El desarrollo de este sistema será una solución para las cooperativas al momento de poder estar al pendiente de los movimientos y que sus usuarios tengan fácil acceso al momento de hacer todo tipo de transacciones, ya que será un sistema amigable con los usuarios al igual que para los administradores, puedan estar al pendiente de los movimientos de sus usuarios y conocer los usuarios del sistema para que no haya necesidad de tener un contacto directo con la base de datos.
