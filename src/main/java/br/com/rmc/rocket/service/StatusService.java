package br.com.rmc.rocket.service;

import br.com.rmc.rocket.entity.Status;
import br.com.rmc.rocket.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Optional<Status> buscarStatusPorId(Long id) {
        return statusRepository.findById(id);
    }

}
