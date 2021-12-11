package io.hashimati.baseApp.controllers;

import io.hashimati.baseApp.domains.Fruit;
import io.hashimati.baseApp.domains.Message;
import io.hashimati.baseApp.services.FruitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@RequestMapping("/api/fruits")
public class FruitController {
    private static final Logger log = Logger.getLogger(FruitController.class.getName());
    private FruitService fruitService;



    public FruitController(FruitService fruitService) {


        this.fruitService = fruitService;
    }



    @Operation(summary = "Creating a fruit and Storing in the database",
            description = "A REST service, which saves Fruit objects to the database.",
            operationId = "SaveFruit"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Object Supplied")
    @ApiResponse(responseCode = "404", description = "Fruit not stored")
    @PostMapping("/save")
    public Message<Fruit> save(@RequestBody Fruit fruit){

        log.info(String.format("Save Fruit: %s", fruit.toString()));
        return fruitService.save(fruit);
    }



    @Operation(summary = "Getting a fruit by Id",
            description = "A REST service, which retrieves a Fruit object by Id.",
            operationId = "FindByIdFruit"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "Fruit not found")

    @GetMapping("/find")
    public Message<Fruit> findById(long id)
    {
       log.info(String.format("Find Fruit by id: %d", id));
        return fruitService.findById(id);
    }




    @Operation(summary = "Deleting a fruit by ID",
            description = "A REST service, which deletes Fruit object from the database.",
            operationId = "DeleteByIdFruit"
    )
    @ApiResponse(
            content = @Content(mediaType = "boolean")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "Fruit not found")
    @DeleteMapping("/delete/{id}")
    public Message<Boolean> deleteById(@PathVariable("id") Long id){
        log.info(String.format("Delete Fruit by id: %d", id));
      return deleteById(id);
    }




    public boolean existsById(Long id)
    {

        log.info(String.format("Check if id exists: %d", id));
        return  fruitService.existsById(id);
    }


    @Operation(summary = "Retrieving all fruit objects as Json",
            description = "A REST service, which returns all Fruit objects from the database.",
            operationId = "FindAllFruit"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @GetMapping("/findall")
    public Iterable<Fruit> findAll()
    {
        log.info("Find all fruits");
        return fruitService.findAll();
    }


    @Operation(summary = "Updating a fruit.",
            description = "A REST service, which update a Fruit objects to the database.",
            operationId = "UpdateFruit"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "404", description = "Fruit not found")
    @PutMapping("/update")
    public Message<Fruit> update(@RequestBody Fruit fruit){
        log.info(String.format("Update Fruit: %s", fruit.toString()));
        return fruitService.save(fruit);
    }

}


