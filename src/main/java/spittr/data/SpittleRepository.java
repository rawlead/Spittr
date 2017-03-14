package spittr.data;

import spittr.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SpittleRepository extends JpaRepository<Spittle, Long> {
    List<Spittle> findSpitles(long max, int count);
}
