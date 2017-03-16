package spittr.daoimpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.*;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    private Map<Long, Spittle> spittles;

    public SpittleRepositoryImpl() {
        spittles = new TreeMap<Long, Spittle>();
        for (int i = 1; i <= 25; i++) {
            Spittle spittle = new Spittle("Spittle " + i, new Date());
            spittles.put((long)i, spittle);
        }
    }

    public List<Spittle> findSpitles(long max, int count) {
        List<Spittle> spittleList = new LinkedList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittleList.add(spittles.get(max));
            max--;
        }
        return spittleList;
    }

    public Spittle findOne(long id) {
        return spittles.get(id);
    }

    public void save(Spittle spittle) {
        long maxid = Collections.max(spittles.keySet());
        spittles.put(maxid+1,spittle);
    }
}
