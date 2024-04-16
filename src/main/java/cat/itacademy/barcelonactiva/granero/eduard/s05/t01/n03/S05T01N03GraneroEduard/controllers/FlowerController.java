package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.services.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    FlowerService flowerService;

    @Operation(summary = "Add new Flower",
               description = "This method is used to add a new flower. The name and country are necessary.")
    @PostMapping("/clientFlowersAdd")
    public ResponseEntity<?> flowerAdd(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.add(flowerEntity);
        return ResponseEntity.ok().body(flowerDTO);
    }

    @Operation(summary = "Update a Flower",
            description = "This method checks if the ID exists, if so, updates it. You need the whole body.")
    @PutMapping("/clientFlowersUpdate")
    public ResponseEntity<?> flowerUpdate(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.update(flowerEntity);
        return ResponseEntity.ok().body(flowerDTO);
    }

    @Operation(summary = "Delete one flower",
            description = "This method checks if the ID exists, if so, it deletes it.")
    @DeleteMapping("/clientFlowerDelete/{id}")
    public HttpStatus flowerDelete(@PathVariable("id") Integer id){
        flowerService.delete(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Show one Flower",
            description = "This method checks if the ID exists, if so, it displays it.")
    @GetMapping("/clientFlowerGetOne/{id}")
    public ResponseEntity<?> flowerGetOne(@PathVariable("id") Integer id){
        FlowerDTO flowerDTO = flowerService.getOneDTO(id);
        return ResponseEntity.ok().body(flowerDTO);
    }

    @Operation(summary = "Show a list of flowers",
            description = "This method shows the complete list of flowers.")
    @GetMapping("/clientFlowerAll")
    public ResponseEntity<?> flowerGetAll(){
        List<FlowerDTO> flowerDTOList = flowerService.getAll();
        return ResponseEntity.ok().body(flowerDTOList);
    }
}
