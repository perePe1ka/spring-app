package ud.uskov.lokomotiv.services;

import ud.uskov.lokomotiv.models.Locomotive;
import java.util.List;


public interface ILocoService {


    void create(Locomotive locomotive);


    Locomotive getLocomotive(Long id);


    void deleteLocomotive(Long id);


    List<Locomotive> getAll();

    void updateLocomotive(Locomotive locomotive);
}

