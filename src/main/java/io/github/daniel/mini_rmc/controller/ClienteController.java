package io.github.daniel.mini_rmc.controller;

import io.github.daniel.mini_rmc.entity.Cliente;
import io.github.daniel.mini_rmc.entity.Contato;
import io.github.daniel.mini_rmc.repository.ClienteRepository;
import io.github.daniel.mini_rmc.repository.ContatoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ContatoRepository contatoRepository;

    public ClienteController(ClienteRepository clienteRepository, ContatoRepository contatoRepository) {
        this.clienteRepository = clienteRepository;
        this.contatoRepository = contatoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    @PostMapping("{id}/contatos")
    public ResponseEntity<Contato> criarContato(@PathVariable Long id, @RequestBody Contato contato){
        Optional<Cliente> optional = clienteRepository.findById(id);

        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        contato.setCliente(optional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(contatoRepository.save(contato));
    }

    @GetMapping("{id}/contatos")
    public ResponseEntity<List<Contato>> listarContatos(@PathVariable Long id){
        Optional<Cliente> optional = clienteRepository.findById(id);

        return optional.map(cliente ->
                ResponseEntity.ok(cliente.getContatos()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
