package br.com.david.lavor.crudClient.service;

import br.com.david.lavor.crudClient.dto.Client;
import br.com.david.lavor.crudClient.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ServiceCrudClient
{
    @Autowired
    ClientRepository clientRepository;
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    public void clientAdd(Client requestClient)
    {
        logger.info("add:\n{}",requestClient);
        clientRepository.save(requestClient);
        logger.info(clientRepository.findAll().toString());
    }

    public List<Client> clientGetAll()
    {
        logger.info("all client:\n{}",clientRepository.findAll().toString());
       return StreamSupport
              .stream(clientRepository.findAll().spliterator(), false)
              .collect(Collectors.toList());

    }

}
