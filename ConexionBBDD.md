Para todos los que querais ir consultando la base de datos os explico como va a funcionar el modulo de conexion con la base de datos.

He creado una clase por cada tabla de la base de datos, de esta manera podremos manejar los datos de las tabla como objetos cuyos atributos se corresponden con los campos de las tabla, es decir, habrá una clase Juegos, Clientes, Partidas.......

Por cada tabla, he creado 5 metodos basicos, por ejemplo, para la tabla Juegos:

> -selectAllJuegos(), devuleve un DefaultTableModel con todos los juegos
> > almaceandos en la tabla.


> -selectJuego(int codigo), devuelve un objeto de la clase juego, cuyo
> > codigo es el solicitado por parámetro.


> -insertJuego(Juego juego), inserta en la tabla juegos, el juego que le
> > pasamos por parametro.


> -updateJuego(Juego juego), actualiza en la tabla juegos, el juego que le
> > pasamos por parametro


> -deleteJuego(int codigo), borra de la tabla Juegos el juego cuyo codigo es
> > el que se pasa por parámetro.

Si a alguien no le gusta o tiene otra idea de como impletar esto que se ponga en contacto conmigo y lo hablamos.
Todas aquellas consultas que necesiteis y no estan implementadas me lo decis.
