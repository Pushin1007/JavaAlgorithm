package hw6;


public class Test {
    public static void main(String[] args) {

        Tree<Integer> tree = new TreeImpl<>();

        tree.add(60);
        tree.add(50);
//        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(69);
        tree.add(67);
        tree.add(68);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

        tree.traverse(Tree.TraversMode.IN_ORDER);
        tree.traverse(Tree.TraversMode.PRE_ORDER);
        tree.traverse(Tree.TraversMode.POST_ORDER);

/*        tree.display();

//        tree.remove(43);
//        tree.remove(67);
//        tree.remove(45);
//        tree.remove(66);
//
//        tree.remove(40);
        tree.remove(60);

        tree.display();*/



    }
}

