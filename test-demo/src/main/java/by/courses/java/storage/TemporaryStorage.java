package by.courses.java.storage;

import java.util.HashMap;
import java.util.Map;

public final class TemporaryStorage {

  private Map<String, Object> storage = new HashMap<>(256);

  private TemporaryStorage() {
  }

  public Object getEntity(String id) {
    return storage.get(id);
  }

  public void insertEntity(String id, Object entity) {
    storage.put(id, entity);
  }

  public static TemporaryStorage getInstance() {
    return Holder.instance;
  }

  private static class Holder {
    private static TemporaryStorage instance = new TemporaryStorage();
  }
}