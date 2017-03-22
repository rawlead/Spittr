package spittr.data;

import spittr.Spitter;

public interface SpitterRepository /*extends JpaRepository<Spitter,Long>*/ {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
