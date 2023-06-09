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

    private List<Locomotive> locomotives;

    @Autowired
    public LocoService( LocoRepository locoRepository) {this.locoRepos = locoRepository;
    }

    @Override
    public void create(Locomotive locomotive){
        locoRepos.save(locomotive);
    }

    @Override
    public Locomotive getLocomotive(Long id){
        Optional<Locomotive> optionalLocomotive = locoRepos.findById(id);
        if (optionalLocomotive.isPresent()) {
            return optionalLocomotive.get();
        } else {
            // Обработка ошибки, если объект не найден
            return null;
        }
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
    public void updateLocomotive(Locomotive locomotive) {
        locoRepos.save(locomotive);
    }







}
