package com.example.Hospital.service;

import com.example.Hospital.Repository.OdontologoRepository;
import com.example.Hospital.exception.ResourceNotFoundException;
import com.example.Hospital.model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {


    private final OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public List<Odontologo> getAllOdontologos() {
        return odontologoRepository.findAll();
    }

    public Odontologo getOdontologoById(Long id) {
        return odontologoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Odontologo no encontrado"));
    }

    public Odontologo saveOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }
}
