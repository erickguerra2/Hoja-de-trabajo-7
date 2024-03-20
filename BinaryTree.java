class BinaryTree<T extends Comparable<T>> {
    private static class Node<T> {
        private T element;
        private Node<T> left;
        private Node<T> right;

        public Node(T element) {
            this.element = element;
            left = null;
            right = null;
        }
    }

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    
    /** 
     * @param element
     */
    public void insert(T element) {
        root = insertRec(root, element);
    }

    
    /** 
     * @param root
     * @param element
     * @return Node<T>
     */
    private Node<T> insertRec(Node<T> root, T element) {
        if (root == null) {
            root = new Node<>(element);
            return root;
        }

        if (element.compareTo(root.element) < 0) {
            root.left = insertRec(root.left, element);
        } else if (element.compareTo(root.element) > 0) {
            root.right = insertRec(root.right, element);
        }

        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    
    /** 
     * @param root
     */
    private void inOrderTraversal(Node<T> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.element + " ");
            inOrderTraversal(root.right);
        }
    }

    
    /** 
     * @return Node<T>
     */
    public Node<T> getRoot() {
        return root;
    }

    
    /** 
     * @param word
     * @return T
     */
    public T search(String word) {
        return searchInDictionaryRec(word, root);
    }

    
    /** 
     * @param word
     * @param root
     * @return T
     */
    private T searchInDictionaryRec(String word, Node<T> root) {
        if (root == null) {
            return null;
        }

        Association<String, String> currentAssociation = (Association<String, String>) root.element;

        if (word.compareTo(currentAssociation.getKey()) == 0) {
            return root.element;
        } else if (word.compareTo(currentAssociation.getKey()) < 0) {
            return searchInDictionaryRec(word, root.left);
        } else {
            return searchInDictionaryRec(word, root.right);
        }
    }
}