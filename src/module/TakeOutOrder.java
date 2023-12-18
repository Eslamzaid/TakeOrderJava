package module;

import java.util.ArrayList;

public class TakeOutOrder {
    private int tickedId;
    private ArrayList<Item> cart;
    private ArrayList<String> instructionsList;

    private ArrayList<Integer> comboIds;

    private String status;
    public TakeOutOrder() {
        this.tickedId = 0;
        this.cart = new ArrayList<>();
        this.instructionsList = new ArrayList<>();
        this.status = "Unaccomplished";
        this.comboIds = new ArrayList<Integer>();
        welcomingMessage();
    }


    // Modifies: this
    // Effects: Prints the recipe to the customer with all the orders he orders and the price and ticketId,
    //          and then sends the order to the kitchen and updates the status
    public void conformOrder() {
        if(this.cart.isEmpty()) System.out.println("Can't conform an empty order");
        else {
            printRecipe();
            updateStatus("preparing");
        }
    }

    // Modifies: this
    // Effects: deletes everything and says a well farewell
    public void cancelOrder() {
        newOrder();
        updateStatus("Unaccomplished");
        System.out.println("Sorry if we have made something wrong, or made you unsatisfied, have a nice day!");
    }

    // Modifies: this
    // Effects: Clear everything up and give the customer his order
    public void finishOrder() {
        newOrder();
        updateStatus("Unaccomplished");
        System.out.println("Enjoy the mean and have a nice day!");
    }


    // Modifies: this
    // Effects: adds an order to the order list
    public void addOrder(Item item) {
        if(checkStatus() == "Unaccomplished") {
            Item selectedItem = searchItemByName(item.getName());
            if(selectedItem != null) {
                item.setPrice(selectedItem.getPrice());
            } else item.setPrice((int) (Math.random() * 100));
            this.cart.add(item);
        } else System.out.println("Can't do this, you already made an order");
    }

    // Modifies: this
    // Effects: Gets the instructions from the user 1 by 1 and stores it
    public void addInstruction(String instruction) {
        if(checkStatus() == "Unaccomplished") this.instructionsList.add(instruction);
        else System.out.println("Can't do this, you already made an order");
    }

    // Requires: A valid status name
    // Modifies: this
    // Effects: Updates the order status to a new one
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Modifies: this
    // Effects: generates a comboId, and stores the comboId in combosList
    public int generatesComboId() {
        int random = (int) (Math.random() * 100);
        if (this.comboIds.contains(random)) return generatesComboId(); // Return the result of the recursive call
        else {
            this.comboIds.add(random);
            return random;
        }
    }


    // Effects: Prints everything in a list and then returns the number of items
    public int getOrderList() {
        System.out.println("Your cart contains: ");
        int count = 0;
        for(Item i: this.cart) {
            count++;
            System.out.println(count+"-----: "+i.getName());
        }

        return count;
    }

    // Effects: Returns the number all the instructions and prints them
    public int getInstructions(){
        int count = 0;
        for(String i: this.instructionsList) {
            count++;
            System.out.println(count+": "+ i);
        }

        return count;
    }


    // Effects: Returns the status of the order
    public String checkStatus() {
        return this.status;
    }

    // Modifies: this
    // Effects: updates the current tickedId number
    private int ticketIdGenerator() {
        this.tickedId++;
        return tickedId;
    }

    // Effects: Prints a welcome message
    private void welcomingMessage() {
        System.out.println("-----------------------                      ---------------------------");
        System.out.println("Hello and welcome tooooooooo Mr.Shnshwerma!!!!!");
        System.out.println("Order anything you want and you will get it with a glance of an eye (Metaphorically)");
        System.out.println("-----------------------                      ---------------------------");
    }

    private void printRecipe() {
        System.out.println("You just made an order! ");
        System.out.println("Your ordered with the number "+ticketIdGenerator()+" have the following items in it: ");
        int totalPrice = 0;
        for (int i = 0; i <= this.cart.size() - 1; i++) {
            System.out.println(i+1 + "---: " + this.cart.get(i).getName());
            totalPrice += this.cart.get(i).getPrice();
        }
        System.out.println("Total price is: "+ totalPrice);
        System.out.println("your order will be ready soon!");
    }

    private void newOrder() {
        updateStatus("Unaccomplished");
        this.cart = new ArrayList<>();
        this.instructionsList = new ArrayList<>();
        this.comboIds = new ArrayList<>();
        this.tickedId=0;
    }

    private Item searchItemByName(String name) {
        for(Item i : this.cart) {
            if(i.getName() == name) {
                return i;
            }
        }
        return null;
    }
}