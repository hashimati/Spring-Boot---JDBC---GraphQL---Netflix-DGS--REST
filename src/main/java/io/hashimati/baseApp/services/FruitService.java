package io.hashimati.baseApp.services;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.hashimati.baseApp.domains.Fruit;
import io.hashimati.baseApp.domains.Message;
import io.hashimati.baseApp.domains.enums.MessageType;
import io.hashimati.baseApp.repository.FruitRepository;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FruitService {
    private static final Logger log = Logger.getLogger(FruitService.class.getName());
    private FruitRepository fruitRepository;


    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Message<Fruit> save(Fruit fruit){
        try {
            Fruit result = fruitRepository.save(fruit);
            if(fruit.getId() > 0)
            {
                return Message.just(fruit, MessageType.SUCCESS, "The fruit is saved successfully!");
            }
            else
                return Message.just(null, MessageType.ERROR, "The fruit is not saved!");

        }
        catch (Exception ex) {
            return Message.just(null, MessageType.ERROR, "The fruit is not saved!");
        }
    }



    public Message<Fruit> findById(Long id)
    {
        Optional<Fruit> result = fruitRepository.findById(id);
        if(result.isPresent())
        {
            return Message.just(result.get(), MessageType.SUCCESS, "Success");
        }
        else{
            return Message.just(null, MessageType.NOT_FOUND, String.format("Cannot find fruit with id = %d", id));
        }
    }
    public Message<Boolean> deleteById(Long id){

        try{
            fruitRepository.deleteById(id);
            return Message.just(true, MessageType.SUCCESS, String.format("The fruit with id= %d is deleted successfully ", id ));
        }
        catch (Exception ex){
            ex.printStackTrace();
            return Message.just(false, MessageType.ERROR, String.format("Failed to delete fruit with id= %d", id ));
        }
    }
    //update fruit
    public Message<Boolean> update(Fruit fruit) {
        try {
            fruitRepository.updateFruit(fruit.getName(), fruit.getId());
            return Message.just(true, MessageType.SUCCESS, "The fruit is updated successfully!");
        } catch (Exception ex) {
            return Message.just(false, MessageType.ERROR, "The fruit is not updated!");
        }
    }


    public boolean existsById(Long id)
    {
        log.info(String.format("Check if id exists: %d", id));
        return  fruitRepository.existsById(id);
    }

    public Iterable<Fruit> findAll()
    {
        return fruitRepository.findAll();
    }

}
