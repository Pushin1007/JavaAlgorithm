package hw6;
/*
1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с глубиной в 4 уровней.
 Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -25 до 25.

2. Проанализировать, какой процент созданных деревьев являются несбалансированными.

Определение сбалансированности :
1. длина пути от корня до любого листового элемента одинакова или отличается не более, чем на единицу;
2. Сбалансированным называют дерево расстояние от корня до самой далёкой вершины которого
меньше или равно Log(N) где N количество элементов в дереве.
 Идея в том, чтобы самый длинный путь от корня к любой из вершин не был бы длиннее Log(N)

Как решать:

При симметричном обходе, когда доходишь до конца левого поддерева возвращаешь в его родитель глубину
(будет 1), потом обходишь правое и возвращаешь его глубину.
Возвращаясь на уровень выше, возвращаешь в качестве глубины максимальное значение из левой и правой глубин,
 в качестве глубины для левого/правого поддерева.
 Параллельно, проверяешь, если после обхода правого поддерева глубины различаются более чем на 1,
 то завершаешь алгоритм и говоришь, что дерево не сбалансировано.

public static boolean isBalanced(Node node) {
return (node == null) ||
isBalanced(node.leftChild) &&
isBalanced(node.rightChild) &&
Math.abs(height(node.leftChild) - height(node.rightChild)) <= 1;
}
private static int height(Node node) {
return node == null ? 0 : 1 + Math.max(height(node.leftChild), height(node.rightChild));
}
 */

public class Main {
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

//        tree.traverse(Tree.TraversMode.IN_ORDER);
//        tree.traverse(Tree.TraversMode.PRE_ORDER);
//        tree.traverse(Tree.TraversMode.POST_ORDER);

      tree.display();
/*
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

