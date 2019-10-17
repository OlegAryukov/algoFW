package hyperskill.collections.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();


    @Override
    public void add(E elem) {
        if (elem != null) {
            if (map.containsKey(elem)) {
                map.replace(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
    }

    @Override
    public void remove(E elem) {
        if (elem != null && map.containsKey(elem)) {
            if (map.get(elem) > 1) {
                map.replace(elem, map.get(elem) - 1);
            } else {
                map.remove(elem);
            }
        }
    }

    @Override
    public void union(Multiset<E> other) {
        if(other!=null && other.size()>0){
            for (E elem : other.toSet()) {
                if (map.containsKey(elem)) {
                    if (map.get(elem) < other.getMultiplicity(elem)) {
                        map.replace(elem, other.getMultiplicity(elem));
                    }
                } else {
                    map.replace(elem, other.getMultiplicity(elem));
                }
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        if (other!=null && other.size() > 0) {
            if(!map.isEmpty()){
                Set<E> elementsForDelete = new HashSet<>();
                for (E elem : this.toSet()) {
                    if (other.contains(elem)) {
                        if (map.get(elem) > other.getMultiplicity(elem)) {
                            map.replace(elem, other.getMultiplicity(elem));
                        }
                    } else {
                        elementsForDelete.add(elem);
                    }
                }
                for(E delElem : elementsForDelete){
                    while (map.containsKey(delElem)){
                        map.remove(delElem);
                    }
                }
            }
        } else {
            map.clear();
        }
    }

    @Override
    public int getMultiplicity(E elem) {
        return map.containsKey(elem) ? map.get(elem) : 0;
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return this.toSet().size();
    }

    @Override
    public int size() {
        return map.keySet().stream().map(e -> map.get(e)).reduce(0, Integer::sum);
    }

    @Override
    public Set<E> toSet() {
        // implement the method
        return map.keySet();
    }
}
