package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.services;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.dto.FlowerDTO;

import java.util.List;

public interface FlowerService {
    FlowerDTO add (FlowerEntity flowerEntity);
    FlowerDTO update (FlowerEntity flowerEntity);
    void delete (Integer flowerID);
    FlowerDTO getOneDTO (Integer flowerID);
    List<FlowerDTO> getAll ();
}
