package com.thoughtworks.capacity.gtb.mvc.service;

import ch.qos.logback.core.net.server.Client;
import com.thoughtworks.capacity.gtb.mvc.Dao.ClientDao;
import com.thoughtworks.capacity.gtb.mvc.exception.ClientAlreadyExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private Map<Integer, ClientDao> clientDaoMap = new HashMap<Integer, ClientDao>();
    public ClientService(){
    }
    public void createClient(ClientDao clientDao) {
        List<ClientDao> clientDaoList = clientDaoMap.values().stream()
                .filter(clientDao1 -> clientDao1.getUsername().equals(clientDao1.getUsername())&&clientDao1.getPassword().equals(clientDao1.getPassword())&&clientDao1.getEmail().equals(clientDao1.getEmail()))
                .collect(Collectors.toList());
        if (clientDaoList!=null||clientDaoList.size()==0){
            throw new ClientAlreadyExistException("用户已存在");
        }else{
            clientDao.setId(clientDaoMap.size()+1);
            clientDaoMap.put(clientDao.getId(), clientDao);
        }

    }

    public ClientDao login(String username, String password) {
        List<ClientDao> clientDaoList = clientDaoMap.values().stream()
                .filter(clientDao -> clientDao.getUsername().equals(username)&&clientDao.getPassword().equals(password)).collect(Collectors.toList());
        if(clientDaoList==null || clientDaoList.size()==0) {
            throw new ClientNotFoundException("用户名或者密码错误");
        }else {
            return clientDaoList.get(0);
        }

    }
}
