package com.thoughtworks.capacity.gtb.mvc.controller;

import ch.qos.logback.core.net.server.Client;
import com.thoughtworks.capacity.gtb.mvc.Dao.ClientDao;
import com.thoughtworks.capacity.gtb.mvc.service.ClientService;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Map;

@RestController
@Validated
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody @Valid ClientDao clientDao){
        clientService.createClient(clientDao);
    }
    @GetMapping("/login")
    @ResponseBody
    public ClientDao clientLogin(@RequestParam String username, @RequestParam String password){
        return clientService.login(username,password);
    }
}
