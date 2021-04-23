package alkayyali.saleh.repo;

import alkayyali.saleh.utils.BinaryFile;

public abstract class Repository<T> {
    protected final BinaryFile<T> reader;
    protected final T loaded;

    public Repository(String path) {
        reader = new BinaryFile<T>(path);        
        this.loaded = reader.read(defualt());
    }

    protected abstract T defualt();

    public void saveProgress() {
        reader.write(loaded);
    }
}
