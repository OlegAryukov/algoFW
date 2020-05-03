package hackerrank.interview.sorting;

public class ComparatorProblem {
    public int compare(Player a, Player b) {
        if (a.getScore() < b.getScore()) {
            return -1;
        } else if (a.getScore() > b.getScore()) {
            return 1;
        } else {
            return a.getName().compareTo(b.getName());
        }
    }
}
