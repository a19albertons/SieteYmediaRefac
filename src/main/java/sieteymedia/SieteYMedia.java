package sieteymedia;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {
    Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;
    

    public void GameControler() {
        baraja = new Baraja();
        baraja.barajar();
        // se van pidiendo cartas al jugar pero matemáticamente a partir de 15 siempre
        // nos pasamos
        // hay 12 cartas de medio puntos, si sacara estas 12 luego cartas con valor 1
        // vemos que a partir de 15 cartas siempre se pasas
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }
    void añadirCartaJugador() {
        Carta c = baraja.darCartas(1)[0];
        // insertamos c en las cartas del jugador
        insertarCartaEnArray(cartasJugador, c);
    }
    Carta[] mostrarJugador(){
        return cartasJugador;
    }
    double valorCartasJugador(){
        return valorCartas(cartasJugador);
    }
    boolean jugadorDentroLimites(double valor){
        if (valor < 7.5) {
            return true;
        }
        else {
            return false;
        }
    }
    void turnoJugador(){
        char opc = 'C';
        while (valorCartas(cartasJugador) < 7.5 && opc == 'C') {
            Carta c = baraja.darCartas(1)[0];
            // insertamos c en las cartas del jugador
            insertarCartaEnArray(cartasJugador, c);
            // mostramos cartas y su valor, si se pasa se sale del bucle
            System.out.println("Éstas son tus cartas jugador:");
//            mostrarCartas(cartasJugador);
            double valor = valorCartas(cartasJugador);
            System.out.println("\n\tValor de cartas: " + valor);
            if (valor < 7.5) {
                // suponemos que el usuario teclea bien !!!
                System.out.println("\n¿Pides [C]arta o te [P]lantas?");
//                opc = sc.next().trim().toUpperCase().charAt(0);
            }

        }
    }
//    funciones de logica del juego que deberían estar bien
double valorCartas(Carta[] cartas) {
    double total = 0.0;
    int val;
    int i = 0;
    while (cartas[i] != null) {
        val = cartas[i].getNumero();
        total += (val > 7) ? 0.5 : val;
        i++;
    }

    return total;
}

    void insertarCartaEnArray(Carta[] cartas, Carta c) {
        // inserta al final detectando el primer null
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;

    }


}
