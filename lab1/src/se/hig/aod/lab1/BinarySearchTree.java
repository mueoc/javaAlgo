package se.hig.aod.lab1;

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
            if(current.element.compareTo(newElement) > 0)
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

        if(current == null)
        {
            root = new TreeNode<>(newElement, null, null);
            size++;
        }

        if(current.element.compareTo(newElement) < 0)
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
        return root.element = searchingE(root, elementToFind);
    }

    private T searchingE(TreeNode<T> current, T elementToFind)
    {
        if(current.element.compareTo(elementToFind) == 0)
        {
            return current.element;
        }
        else
        {
            if(current.element.compareTo(elementToFind) < 0)
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
            return toStringE(current.right) + current.element.toString() + toStringE(current.left);
        }
    }
}


 