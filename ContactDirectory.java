public class ContactDirectory {
    ContactNode insertContact(ContactNode root,String name, String phoneNumber){

        if (root == null){
            root = new ContactNode(name,phoneNumber);// new node
            return root;
        }
        if(name.equals (root.name)){
            root.phoneNumber = phoneNumber; // phone number updated
            return root;
        }
        if (name.compareTo(root.name) < 0){
            root.left = insertContact(root.left,name,phoneNumber);
        }else{
            root.right = insertContact(root.right,name,phoneNumber);
        }

        return root;

    }
    public String searchContact(ContactNode root, String name){
        if (root == null){
            System.out.println("the person is not found");
            return null;//?
        }
        if(name.equals (root.name)){
            return root.phoneNumber;
        }
        if (name.compareTo(root.name)<0){
            return searchContact(root.left,name);
        }else{
            return searchContact(root.right,name);
        }
    }
    public void displayAllContacts(ContactNode root){
        if(root != null){
            displayAllContacts(root.left);
            System.out.println("name:"+root.name +",phone number: " + root.phoneNumber);
            displayAllContacts(root.right);
        }
    }
    public ContactNode deleteContact(ContactNode root,String name) {
        if (root == null) {
            System.out.println("The person is not found.");
            return null;
        }
        if (name.equals(root.name)) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            String smallestValue = findSmallestValue(root.right);
            root.name = smallestValue;
            root.right = deleteContact(root.right, smallestValue);
            return root;
        }
        if (name.compareTo(root.name)<0) {
            root.left = deleteContact(root.left, name);
        } else {
            root.right = deleteContact(root.right, name);
        }
        return root;
    }
    private String findSmallestValue(ContactNode root){
        if (root.left == null){
            return root.name;
        }else{
            return findSmallestValue(root.left);
        }
    }
}
