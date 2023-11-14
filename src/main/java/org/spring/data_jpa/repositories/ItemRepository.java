package org.spring.data_jpa.repositories;

import org.spring.data_jpa.model.Item;
import org.spring.data_jpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByItemName(String itemName);

    List<Item> findByOwner(Person owner);
}
