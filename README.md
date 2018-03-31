# cia-elasticsearch
Notas importantes:
-Acordarse de setear o deshabilitar los firewall entre el cliente y el servidor.
-No se pudo utilizar doker debido a la falta de arquitecturas de 64-bits para el proyecto.

Parte servidor:

1-Una vez descomprido elasticsearch-2.4.0, setear en el archivo config/elasticsearch.yml la ip por donde escuchara los pedidos del cliente:

network.host:   miip (recordar quitar el #)

Luego el servidor se inicia con bin/elasticksearch.bat

2-Una vez descomprimido kibana-4.3.1-windows, setear en el archivo config/kibana.yml la ip y puerto donde escucha la instancia elasticsearch por las consultas:

elasticsearch.url:  por ejemplo http://192.168.1.36:9200

Luego se inicia con bin/kibana.bat

Parte cliente:
Para la conexion con la BD elasticsearch se debe configurar los siguientes parametros de la aplicacion, con los valores que seran utilizados en el ambiente de prueba (src/main/resources/application.properties):

elasticsearch.host = ip del server por ejemplo 192.168.1.34


El archivo lista-libros.json , contiene a la lista de libros en formato json.