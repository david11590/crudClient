package br.com.david.lavor.crudClient.rest;

import br.com.david.lavor.crudClient.dto.Client;
import br.com.david.lavor.crudClient.service.ServiceCrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/client")
public class RestControllerCrudClient
{
    @Autowired
    ServiceCrudClient serviceCrudClient;
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<?> postInsertClient(@RequestBody Client requestClient)
    {
        serviceCrudClient.clientAdd(requestClient);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping
    @RequestMapping("/get")
    public ResponseEntity<?> getClient()
    {
        return new ResponseEntity<>(serviceCrudClient.clientGetAll(),HttpStatus.OK) ;
    }

}
