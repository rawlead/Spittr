package spittr.data;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.Spitter;

public interface SpitterRepository /*extends JpaRepository<Spitter,Long>*/ {
    Spitter findByUsername(String username);
    boolean save(Spitter spitter);
}
