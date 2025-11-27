package se.hig.aod.lab1;

import java.io.BufferedReader;
import java.io.FileReader;
// import java.nio.file.Files;
// import java.nio.file.Paths;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchTree<T extends Comparable<? super T>> implements SearchableDataStructure<T>{
    
    public class TreeNode<T> {

        T element;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode(T element, TreeNode<T> left,TreeNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode<T> root;
    int size = 0;

    public int size()
    {
        return size;
    }

    public void addElement(T newElement)
    {
        TreeNode<T> current = root;

        if(current == null)
        {
            root = new TreeNode<>(newElement, null, null);
            size++;
        }
        else
        {
            if(current.element.compareTo(newElement) < 0)
            {
                if(current.right == null)
                {
                    root.right = new TreeNode<>(newElement, null, null);
                    size++;
                }
                else
                    addingE(root, newElement);
            }
            else
            {
                if(current.left == null)
                {
                    root.left = new TreeNode<>(newElement, null, null);
                    size++;
                }
                else
                    addingE(root, newElement);
            }
        }
    }

    private void addingE(TreeNode<T> current, T newElement)
    {

        if(current.element.compareTo(newElement) > 0)
        {
            if(current.left == null)
            {
                current.left = new TreeNode<>(newElement, null, null);
                size++;
            }
            else
            {
                addingE(current.left, newElement);
            }
        }
        else
        {
            if(current.right == null)
            {
                current.right = new TreeNode<>(newElement, null, null);
                size++;
            }
            else
            {
                addingE(current.right, newElement);
            }
        }
    }

    public T searchElement(T elementToFind)
    {
        return searchingE(root, elementToFind);
    }

    private T searchingE(TreeNode<T> current, T elementToFind)
    {
        // 1. Base Case: If we reached a dead end, the element isn't here.
        if (current == null) {
            return null; 
        }
        
        if(current.element.compareTo(elementToFind) == 0)
        {
            return current.element;
        }
        else
        {
            if(current.element.compareTo(elementToFind) > 0)
            {
                return searchingE(current.left, elementToFind);
            }
            else
            {
                return searchingE(current.right, elementToFind);
            }
        }
    }

    public String toString()
    {
        return toStringE(root);
    }

    private String toStringE(TreeNode<T> current)
    {
        if(current == null)
        {
            return "";
        }
        else
        {
            return toStringE(current.left) + current.element.toString() + toStringE(current.right);
        }
    }

    public String elementToSeatchForSuffle() {
        String fileName = "C:\\Users\\muqta\\Downloads\\javaAlgo\\lab1\\src\\se\\hig\\aod\\lab1\\unique_integers.txt";
        try( BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            // A: skapa listan med element att söka efter
            List<Integer> elementsToSearchFor =
                loadListFromFile(fileName, 2560000);

            int[] numberOfElement = {10000, 20000, 40000, 80000, 160000, 320000, 640000, 1280000, 2560000};

            for (int N : numberOfElement) {

                BinarySearchTree<Integer> bst = new BinarySearchTree<>();

                List<Integer> dataList = loadListFromFile(fileName, N);

                Collections.shuffle(dataList);

                for (int x : dataList)
                    bst.addElement(x);

                long t1 = System.currentTimeMillis();
                for (int v : elementsToSearchFor)
                    bst.searchElement(v);
                long exeTime = System.currentTimeMillis() - t1;

                System.out.println(
                    "N = " + N + ", search time = " + exeTime + " ms");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IOException e)
        {
            System.out.println("IO Exception");
        }
    
        return " ";
    }

        public String elementToSeatchForSort() {
        String fileName = "C:\\Users\\muqta\\Downloads\\javaAlgo\\lab1\\src\\se\\hig\\aod\\lab1\\unique_integers.txt";
        try( BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            // A: skapa listan med element att söka efter
            List<Integer> elementsToSearchFor =
                loadListFromFile(fileName, 2560000);

            int[] numberOfElement = {10000};

            for (int N : numberOfElement) {

                BinarySearchTree<Integer> bst = new BinarySearchTree<>();

                List<Integer> dataList = loadListFromFile(fileName, N);

                Collections.sort(dataList);

                for (int x : dataList)
                
                bst.addElement(x);
                
                // 5. mät söktid
                long t1 = System.currentTimeMillis();
                for (int v : elementsToSearchFor)
                    bst.searchElement(v);
                long exeTime = System.currentTimeMillis() - t1;

                System.out.println(
                    "N = " + N + ", search time = " + exeTime + " ms");

            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IOException e)
        {
            System.out.println("IO Exception");
        }
    
        return " ";
    }

    private static List<Integer> loadListFromFile(String path, int size)
        throws FileNotFoundException, IOException {
        List<Integer> list = new ArrayList<Integer>();
        int cnt = 0;
        try (Scanner in = new Scanner(new FileReader(path))) {
            while (cnt < size && in.hasNextLine()) {
                String line = in.nextLine();
                try {
                    list.add(Integer.parseInt(line));
                    cnt++;
                } catch (NumberFormatException nfe) {
                    // System.err.printf("Not an integer while reading from data file
                    // // \"%s\": %s (ignoring)%n", path, nfe.getLocalizedMessage());
                    System.out.println("Not an integer while reading from data file");

                }
            }
        }

        // här har in.close() garanterat anropats
        if (cnt != size) {
            System.err.printf("Didn't read %d integers, only %d.%n", size, cnt);
        }

        return list;
    
    }
}


 