package com.orderely.restaurant.management.service.impl;

import com.orderely.restaurant.management.DTO.request.AddressRequestDto;
import com.orderely.restaurant.management.DTO.response.AddressResponseDto;
import com.orderely.restaurant.management.exception.ResourceNotFoundException;
import com.orderely.restaurant.management.mapper.AddressMapper;
import com.orderely.restaurant.management.model.Address;
import com.orderely.restaurant.management.repository.AddressRepository;
import com.orderely.restaurant.management.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponseDto createAddress(AddressRequestDto dto) {
        Address address= addressMapper.toEntity(dto);
        Address savedAddress =addressRepository.save(address);
        return  addressMapper.toDto(savedAddress);
    }

    @Override
    public List<AddressResponseDto> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponseDto getAddressById(Long id) {
      Address address =addressRepository.findById(id)
              .orElseThrow(()->new ResourceNotFoundException("Address  not found with id: " + id));
      return addressMapper.toDto(address);
    }

    @Override
    public AddressResponseDto updateAddress(Long id, AddressRequestDto dto) {
       Address existing = addressRepository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Address  not found with id: " + id));
       addressMapper.updateEntity(existing,dto);
       Address updated =addressRepository.save(existing);
       return addressMapper.toDto(updated);
    }

    @Override
    public void deleteAddress(Long id) {
     if (!addressRepository.existsById(id)){
         throw new ResourceNotFoundException("Address  not found with id: " + id);
     }
     addressRepository.deleteById(id);
    }
}
