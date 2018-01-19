#Proyecto final

Crear una aplicación en netbeans con java como lenguaje de programación que permita simular un juego de pokemon rojo fuego. Bajo las siguientes reglas:
Al comenzar el juego revisara si existe un entrenador en la base de datos. Si existe cargara los datos del juego si no existe enviara a una ventana donde pedirá todos los datos necesarios para crear un nuevo entrenador (nombre, apellido, nacionalidad)
Una vez dentro del juego mostrara un menú donde mostrara el nombre y apellido del entrenador en la parte superior y mostrara botones con las siguientes opciones:
* Pedir pokemon inicial
* Recorrer mapa
* Alimentar pokemon
* Hacer dormir pokemon

Cuando se pide el pokemon inicial se seleccionara un pokemon de 3 que se darán como opción.
Los pokemon tendrán los siguientes atributos. 
* Id
* Nombre
* Tipo
* Nivel
* Experiencia
* Daño
* Hambre
* Energía
Cada 1 minuto el pokemon perderá 10 de energía y  su hambre aumentara en 5. Esto mientras no este realizando nada.
Si se alimenta al pokemon se le puede dar:
* Comida chatarra que disminuye en 30 el hambre pero aumenta en 5 el daño
* Comida saludable que disminuye en 20 el hambre y aumenta en 10 la energía
* Snack disminuye en 10 el hambre y aumenta en 5 la energía
Al hacer dormir el pokemon entrara en estado de sueño por 30 segundos y recuperara el 100 de energía y su daño disminuye en 50
Al recorrer el mapa se generara una batalla random con alguno de los 10 pokemons que estarán precargados en la base de datos. La batalla será por turnos y los ataques del pokemon adversario serán aleatoreos.
Ganara el pokemon que deje con daño 100 primero al otro pokemon.
El pokemon muere cuando su hambre llega a 100 su energía a 0 y su daño en 100.
Ud decidirá los ataques de cada pokemon.

Si el pokemon gana una batalla, gana 5 puntos de exp por cada nivel que tenga el pokemon adversario.
Cada 100 de exp pasa al siguiente nivel. Nivel max 99.
