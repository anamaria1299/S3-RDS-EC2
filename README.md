# Tutorial EC2-RDS-S3

En este tutorial se podrá ver cómo se crea y despliega:

* [Un contenido estatico en S3](#S3)
* [Una aplicación desarrollada en Sprign con gradle y conectada a una base de datos RDS postgres SQL](#EC2)
* [Una base de datos en RDS con postgres SQL](#RDS)

## S3

En esta primera parte vamos a entrar a la consola de aws y luego en la parte de servicios iremos a Storage y señalalemos S3 

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%201.png)

Una vez hecho esto, lograremos ubicarnos en S3 y lo siguiente será crear un nuevo bucket

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%202.png)

cuando seleccionamos la opción de crear un nuevo bucket nos aparecerá una pantalla como la siguiente y en ese caso escribiremos el nombre del bucket y le daremos en la opción de crear

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%203.png)

ahora cambiaremos las configuraciones de acceso publico, para lo cual señalaremos la opción que se tiene en la siguiente pantalla

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%204.png)

una vez hecho esto, vamos a quitar el bloqueo de acceso publico y guardaremos

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%205.png)

finalmente, para terminar con la configuración de accesos escribimos la palabra "confirm" en la pantalla que nos ha salido justo despues de guardar las configuraciones

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%206.png)

ahora entraremos dentro del bucket creado y señalaremos la opción que dice subir archivo

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%207.png)

nos aparecera una pantalla como la siguiente para señalar el archivo que queremos 

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%208.png)

en la siguiente pantalla podemos notar como se ve la selección del archivo, en este caso una imagen

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%209.png)

para terminar de subir el archivo le damos subir

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%2010.png)

nos aparecerá una pantalla como la siguiente si todo fue creado y subido exitosamente

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%2011.png)

luego señalaremos el archivo y vamos a ir a la url del objeto, para poder visualizar nuestro archivo

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%2012.png)

una vez hecho esto, nos damos cuenta que no nos permite el acceso, por lo que nos devolvemos a la anterior pantalla

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%2013.png)

nos aparecera una pantalla como esta en donde señalaremos la parte de hacer pública y luego volveremos a entrar a la url

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%2014.png)

debería poder ver una pantalla con la url del objeto y el archivo que usted subio

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/S3/S3%2015.png)

## EC2

Ahora volveremos a la parte de servicios, pero en este caso entraremos a la parte de compute y señalaremos el EC2

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%201.png)

Una vez hecho lo anterior, podremos ver una pantalla como la siguiente e iremos a la parte donde dice launch instance

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%202.png)

luego eligiremos la imagen de la máquina Amazon Linux 2 AMI

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%203.png)

continuamos eligiendo el tipo de instancia y tomamos la que se muestra a continuación, luego de esto hacemos review and launch

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%204.png)

finalmente para terminar de construir la instancia le damos launch

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%205.png)

se nos mostrará una pantalla como la siguiente en la cual debemos crear un par de llaves que nos servirán para poder acceder a la máquina mediante ssh y sftp, estas llaves no se pueden perder así que es recomendable tenerlas en un lugar seguro

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%206.png)

en este paso se muestra donde se estan guardando esas llaves

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%207.png)

cuando ya se hayan guardado las llaver le damos launch instance

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%208.png)

una vez hecho esto, nos aparecerá una pantalla como la siguiente

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%209.png)

luego de esto le damos view instance, para ver el estado en el que esta

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%2010.png)

cuando termine de estar en estado pendiente y pasar a un estado donde ya se esta ejecutando, se va a señalar y se dará click en el boton de conectar

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%2011.png)

cuando se ha dado click sobre el boton, se mostraran unos comandos de cómo nos podemos conectar a la máquina

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%2012.png)

podemos probar estos en la consola de la siguiente forma, además debemos estar ubicados en el directorio donde esta la llave que guardamos anteriormente

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%2013.png)

## RDS

Para esta parte iremos de nuevo a servicios y escogeremos en la parte de bases de datos a RDS, una vez hecho esto nos aparecerá una pantalla como la siguiente

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/1%20database.png)

luego le daremos en crear base de datos y nos aparecerán las siguientes opciones, donde señalaremos postgres para este caso o también puede ser la que se sientan más comodos

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/2%20database.png)

una vez hecho esto, seguiremos bajando por las configuraciones y señalaremos en los templates el free tier

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/3%20database.png)

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/4%20database.png)

luego, en esta sección vamos a permitir el acceso publico, por lo cual se señala la opción de "Si"

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/EC2/EC2%2014.png)

finalmente nos aparecerá una pantalla como la siguiente donde podremos ver los detalles de la conexión

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/5%20database.png)

luego podremos ver el estado de nuestra base de datos

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/6%20database.png)

finalmente, es necesario que entremos a la base de datos y en la pantalla que se muestra bajar hasta un lugar donde diga reglas de grupo de seguridad

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/7%20database.png)

luego, entrar al grupo de seguridad y en la parte donde dice inbound rules señalarla y agregar la regla que se requiera, en este caso se permitio que el tipo postgresSQL con protocolo TCP se pudiera conectar desde cualquier fuente mediante el puerto 5432

![](https://github.com/anamaria1299/S3-RDS-EC2/blob/master/resources/RDS/8%20database.png)
