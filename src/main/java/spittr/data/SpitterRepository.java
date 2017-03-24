package spittr.data;

import spittr.Spitter;

import java.util.List;

public interface SpitterRepository /*extends JpaRepository<Spitter,Long>*/ {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
    boolean spitterExists(String username);
    List<Spitter> findAllSpitters();
}
