package io.hashimati.baseApp.graphql;


import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.hashimati.baseApp.domains.Fruit;
import io.hashimati.baseApp.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@DgsComponent
public class FruitFetcher {

    private static final Logger log = Logger.getLogger(FruitFetcher.class.getName());

    @Autowired
    private FruitService fruitService;

    @DgsMutation
    public Fruit save(@InputArgument Fruit fruit){
        try {
            return fruitService.save(fruit).getData();
        }
        catch (Exception ex) {
            return null;
        }
    }

    @DgsQuery
    public Fruit findById(@InputArgument long id)
    {
        return fruitService.findById(id).getData();
    }

    @DgsMutation
    public Boolean deleteById(@InputArgument long id){

        return fruitService.deleteById(id).getData();
    }

    @DgsMutation
    public Fruit update( @InputArgument Fruit fruit) {
        return save(fruit);
    }


    @DgsQuery
    public boolean existsById(@InputArgument long id)
    {
        log.info(String.format("Check if id exists: %d", id));
        return fruitService.existsById(id);
    }

    @DgsQuery
    public Iterable<Fruit> findAll()
    {
        return fruitService.findAll();
    }

}
