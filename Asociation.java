class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    
    /** 
     * @return K
     */
    public K getKey() {
        return key;
    }

    
    /** 
     * @return V
     */
    public V getValue() {
        return value;
    }

    
    /** 
     * @param other
     * @return int
     */
    @Override
    public int compareTo(Association<K, V> other) {
        return this.key.compareTo(other.getKey());
    }
}