package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    FlowerService flowerService;

    @GetMapping("/clientFlowersAdd")
    public ResponseEntity<?> flowerAdd(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.add(flowerEntity);
        return ResponseEntity.ok().body(flowerDTO);
    }

    @PutMapping("/clientFlowersUpdate")
    public ResponseEntity<?> flowerUpdate(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.update(flowerEntity);
        return ResponseEntity.ok().body(flowerDTO);
    }

    @DeleteMapping("/clientFlowerDelete/{id}")
    public HttpStatus flowerDelete(@PathVariable("id") Integer id){
        flowerService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/clientFlowerGetOne/{id}")
    public ResponseEntity<?> flowerGetOne(@PathVariable("id") Integer id){
        FlowerDTO flowerDTO = flowerService.getOneDTO(id);
        return ResponseEntity.ok().body(flowerDTO);
    }

    @GetMapping("/clientFlowerAll")
    public ResponseEntity<?> flowerGetAll(){
        List<FlowerDTO> flowerDTOList = flowerService.getAll();
        return ResponseEntity.ok().body(flowerDTOList);
    }
}
