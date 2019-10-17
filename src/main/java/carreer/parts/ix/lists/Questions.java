package carreer.parts.ix.lists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Questions<T> {

    public List<T> deleteDuplicates(LinkedList<T> source) {
        Set<T> set = new HashSet<>();
        if (!source.isEmpty()) {
            for (T t : source) {
                set.add(t);
            }
        }
        LinkedList<T> res = null;
        if(!set.isEmpty()){
           res = set.stream().collect(Collectors.toCollection(LinkedList::new));
        }
        return res;
    }

    public void deleteElement(T node){
        
    }

    public static void main(String[] args) {
        LinkedList<String> src = new LinkedList<>();
        src.add("aaa");
        src.add("aaa");
        src.add("aca");
        src.add("aaa");
        src.add("aba");
        src.add("aca");
        src.add("ada");
        src.add("afa");
        Questions<String> test = new Questions<>();
        System.out.println(test.deleteDuplicates(src));
    }
}
