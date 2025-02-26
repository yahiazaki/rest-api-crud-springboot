package com.example.aspectlab1.controller;

import com.example.aspectlab1.model.address;
import com.example.aspectlab1.repository.MysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TestControllers {

    @Autowired
    MysqlRepository mysqlRepository;
    @GetMapping("/user-addresses")
    public List<address> getAllAddresses() {
        return mysqlRepository.findAll();
    }

    @GetMapping("/user-addresses/{id}")
    public address getAddressById(@PathVariable int id) {
        return mysqlRepository.findById(id).get();
    }

    @DeleteMapping("/remove-user/{id}")
    public boolean deleteUser(@PathVariable int id) {
        if(!mysqlRepository.findById(id).equals(Optional.empty())) {
            mysqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update-user/{id}")
    public address updateAddress(@PathVariable int id, @RequestBody Map<String, String> body){

        address current = mysqlRepository.findById(id).get();
        current.setStreet(body.get("street")); //retrieving the value by providing the key
        current.setPostcode(body.get("postcode"));
        current.setNumber(Integer.parseInt(body.get("number")));

        mysqlRepository.save(current);
        return current;
    }

    @PostMapping("/add-user")
    public address addUser(@RequestBody Map<String, String> body){
        String street = body.get("street");
        String postcode = body.get("postcode");
        int number = Integer.parseInt(body.get("number"));

        address address = new address(number, street, postcode);
        return mysqlRepository.save(address);

    }
}
