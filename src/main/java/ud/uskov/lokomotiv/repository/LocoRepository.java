package ud.uskov.lokomotiv.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ud.uskov.lokomotiv.models.Locomotive;

@Repository
public interface LocoRepository extends CrudRepository<Locomotive, Long> {

}
