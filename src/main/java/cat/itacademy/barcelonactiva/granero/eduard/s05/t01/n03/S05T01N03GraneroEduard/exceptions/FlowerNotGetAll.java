package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.exceptions;

public class FlowerNotGetAll extends RuntimeException{
    public FlowerNotGetAll(){
        super("The database are empty.");
    }
}
