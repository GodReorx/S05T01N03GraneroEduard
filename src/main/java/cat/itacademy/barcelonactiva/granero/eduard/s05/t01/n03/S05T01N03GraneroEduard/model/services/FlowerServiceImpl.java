package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.services;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.exceptions.FlowerNotCreated;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.exceptions.FlowerNotGetAll;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.dto.FlowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;

@Service
public class FlowerServiceImpl implements  FlowerService{
    //ToDo: Acabar los try and catch
    @Autowired
    private WebClient webClient;

    @Override
    public FlowerDTO add(FlowerEntity flowerEntity) {
        try {
            return webClient.post().uri("/flower/add").bodyValue(flowerEntity).retrieve().bodyToMono(FlowerDTO.class).block();
        }catch (Exception e) {
            throw new FlowerNotCreated();
        }
    }

    @Override
    public FlowerDTO update(FlowerEntity flowerEntity) {
        return webClient.put().uri("/flower/update").bodyValue(flowerEntity).retrieve().bodyToMono(FlowerDTO.class).block();
    }

    @Override
    public void delete(Integer flowerID) {
        webClient.delete().uri("/flower/delete/{id}", flowerID).retrieve().toBodilessEntity().block();
    }

    @Override
    public FlowerDTO getOneDTO(Integer flowerID) {
        return webClient.get().uri("/flower/getOne/{id}", flowerID).retrieve().bodyToMono(FlowerDTO.class).block();
    }

   @Override
    public List<FlowerDTO> getAll() {
        try {
            return webClient.get()
                    .uri("/flower/getAll")
                    .retrieve()
                    .bodyToFlux(FlowerDTO.class)
                    .collectList().block();
        }catch (Exception e){
            throw new FlowerNotGetAll();
        }
    }
}
