package ManusDei.proxy;

public class MemoryCache {
    byte[] data;
    int length;
    String lastModified;

    public MemoryCache(byte[] data, int length, String lastModified) {
        this.data = data;
        this.length = length;
        this.lastModified = lastModified;
    }
}
