

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class Storage {

    private ConcurrentHashMap<Long, Student> storage = new ConcurrentHashMap<>();

    public ConcurrentHashMap<Long, Student> getStorage() {
        return storage;
    }
}
