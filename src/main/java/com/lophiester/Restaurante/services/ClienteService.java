package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Cidade;
import com.lophiester.Restaurante.domain.Cliente;
import com.lophiester.Restaurante.domain.Endereco;
import com.lophiester.Restaurante.domain.dto.ClienteDTO;
import com.lophiester.Restaurante.domain.dto.ClienteNewDTO;
import com.lophiester.Restaurante.repositories.ClienteRepository;
import com.lophiester.Restaurante.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(null);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linePerPage, Sort.Direction direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, direction, orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = findById(obj.getId());
        updateData(newObj, obj);
        return clienteRepository.save(newObj);
    }

    public void delete(Integer id) {
        findById(id);
        clienteRepository.deleteById(id);

    }

    public Cliente fromDTO(ClienteDTO objDTO) {
        return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
    }

    public Cliente fromDTO(ClienteNewDTO newDTO) {
        Cliente cli = new Cliente(null, newDTO.getNome(), newDTO.getEmail());
        Cidade ci = new Cidade(newDTO.getCidadeId(), null, null);
        Endereco end = new Endereco(null, newDTO.getBairro(), newDTO.getComplemento(), newDTO.getCep(), ci, cli);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(newDTO.getTelefone1());
        if (newDTO.getTelefone2() != null) {
            cli.getTelefones().add(newDTO.getTelefone2());
            if (newDTO.getTelefone3() != null) {
                cli.getTelefones().add(newDTO.getTelefone3());
            }

        }
        return cli;
    }

    public void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}