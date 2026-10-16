package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService implements IContratService {

    private final ContratRepository contratRepository;

    @Autowired
    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Optional<Contrat> getContratById(Long idContrat) {
        return contratRepository.findById(idContrat);
    }

    @Override
    public void deleteContratById(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public void deleteAllContrats() {
        contratRepository.deleteAll();
    }
}
