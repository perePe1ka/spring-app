package ud.uskov.lokomotiv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ud.uskov.lokomotiv.models.Locomotive;
import ud.uskov.lokomotiv.repository.LocoRepository;

import java.util.List;
import java.util.Optional;


@Service
public class LocoService implements ILocoService {

    private final LocoRepository locoRepos;

    @Autowired
    public LocoService( LocoRepository locoRepository) {this.locoRepos = locoRepository;
    }

    @Override
    public void create(Locomotive locomotive){
        locoRepos.save(locomotive);
    }

    @Override
    public Optional<Locomotive> getLocomotive(Long id){
        return locoRepos.findById(id);
    }

    @Override
    public void deleteLocomotive(Long id){
        locoRepos.deleteById(id);
    }

    @Override
    public List<Locomotive> getAll(){
        return (List<Locomotive>) locoRepos.findAll();
    }


    @Override
    public Locomotive updateLocomotive(Locomotive locomotive) {
        return locoRepos.save(locomotive);
    }


}
