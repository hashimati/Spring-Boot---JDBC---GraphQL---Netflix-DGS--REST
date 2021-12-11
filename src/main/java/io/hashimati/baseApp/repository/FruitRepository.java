package io.hashimati.baseApp.repository;

import io.hashimati.baseApp.domains.Fruit;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {

    //update fruit

    @Modifying
    @Query("UPDATE fruits SET name = ?1, price = ?2 WHERE id = ?3")
    void updateFruit(String name, Long id);



}
