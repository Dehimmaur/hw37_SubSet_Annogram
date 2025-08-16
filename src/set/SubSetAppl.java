package set;

public class SubSetAppl {

    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        System.out.println("=========SubSet===============");
        System.out.println("SubSet[5, 15): " + tree.subSet(5, 15)); // [5, 7, 10, 12]
        System.out.println("SubSet[6, 18): " + tree.subSet(6, 18)); // [7, 10, 12, 15]
        System.out.println("=========TrimSet============");

        System.out.print("Full set: ");
        tree.traverse();
        tree.trimSet(5, 15);
        System.out.print("\nTrim [5,15]: ");
        tree.traverse();
    }
}
