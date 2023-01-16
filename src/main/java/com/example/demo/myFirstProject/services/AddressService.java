package com.example.demo.myFirstProject.services;

import com.example.demo.myFirstProject.badRequestException.BadRequestException;
import com.example.demo.myFirstProject.model.Address;
import com.example.demo.myFirstProject.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address findByIdOrThrowBadRequestException(long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Address not found"));
    }

    public List<Address> listAll() {
        return addressRepository.findAll();
    }

    public List<Address> findByLocalidadeLike(String localidade) {
        return addressRepository.findByLocalidadeLike(localidade);
    }

    //save
    @Transactional
    public Address save(Address address) {
        return addressRepository.save(Address.builder()
                .cep(address.getCep())
                .logradouro(address.getLogradouro())
                .number(address.getNumber())
                .bairro(address.getBairro())
                .localidade(address.getLocalidade())
                .uf(address.getUf())
                .build());
    }

    public void replace(Address address) {
        findByIdOrThrowBadRequestException(address.getId());
        Address address1 = Address.builder()
                .cep(address.getCep())
                .logradouro(address.getLogradouro())
                .number(address.getNumber())
                .bairro(address.getBairro())
                .localidade(address.getLocalidade())
                .uf(address.getUf())
                .build();
        addressRepository.save(address);
    }

    public void delete(long id) {
        addressRepository.delete(findByIdOrThrowBadRequestException(id));
    }


}
