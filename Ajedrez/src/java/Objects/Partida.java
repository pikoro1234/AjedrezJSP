package Objects;

public class Partida {
    
    private boolean Turno;
    

    public Partida(boolean Turno, Jugador jugador) {
        this.Turno = Turno;
    }
    
    public Partida() {

    }

    public boolean isTurno() {
        return Turno;
    }

    public void setTurno(boolean Turno) {
        this.Turno = Turno;
    }
    
    public int iniciarPartida(String userUno, String userDos){
        //Math.random()*6
        //  int valorEntero = Math.floor(Math.random()*(N-M+1)+M);
        int randomUsuarios = (int) (Math.random()*2);
        
        return randomUsuarios;
    }
    
    
    
}
