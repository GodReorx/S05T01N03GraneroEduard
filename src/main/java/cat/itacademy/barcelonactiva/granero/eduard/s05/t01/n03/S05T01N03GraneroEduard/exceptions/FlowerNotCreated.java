package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.exceptions;

public class FlowerNotCreated extends RuntimeException{
    public FlowerNotCreated (){
        super("Can't create a new flower at BBDD, contact with your administrator");
    }
}
