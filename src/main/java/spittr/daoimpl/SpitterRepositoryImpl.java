package spittr.daoimpl;

import org.springframework.stereotype.Component;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import java.util.*;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    private Map<String, Spitter> spitters;

    public SpitterRepositoryImpl() {
        spitters = new HashMap<String, Spitter>();
    }

    public Spitter findByUsername(String username) {
        return spitters.get(username);
    }

    public boolean save(Spitter spitter) {
        if (!spitters.keySet().contains(spitter.getUsername())) {
            spitters.put(spitter.getUsername(), spitter);
            return true;
        }
        return false;
    }
}
