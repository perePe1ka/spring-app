package ud.uskov.lokomotiv.services;

import ud.uskov.lokomotiv.models.Locomotive;
import java.util.List;
import java.util.Optional;


public interface ILocoService {


    void create(Locomotive locomotive);


    Optional<Locomotive> getLocomotive(Long id);


    void deleteLocomotive(Long id);


    List<Locomotive> getAll();

    Locomotive updateLocomotive(Locomotive locomotive);
}

