package spittr.data;

import spittr.Spittle;


import java.util.List;


public interface SpittleRepository /*extends JpaRepository<Spittle, Long> */{
    List<Spittle> findRecentSpittles();
    List<Spittle> findSpitles(long max, int count);
    Spittle findOne(long id);
    void save(Spittle spittle);
}
