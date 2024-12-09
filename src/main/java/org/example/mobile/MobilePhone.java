package org.example.mobile;


import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;

    public List<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (myContacts.contains(contact)) {
            return false;
        } else {
            myContacts.add(contact);
            return true;

        }
    }
    public boolean updateContact(Contact contact, Contact contact1) {
        if(myContacts.contains(contact)) {
            int index = myContacts.indexOf(contact);
            if (index != -1) {
                myContacts.set(index, contact1);
                return true;
            }

        } else {
            return false;
        }
    return false;
    }

    public boolean removeContact(Contact contact) {
        if (myContacts.contains(contact)) {
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }
    public int findContact(Contact contact) {
        if (myContacts.contains(contact)) {
            return myContacts.indexOf(contact);
        } else {
            return -1;
        }
    }
    public int findContact(String contact) {
        if (myContacts.contains(contact)) {
            return myContacts.indexOf(contact);
        } else {
            return -1;
        }
    }
    public Contact queryContact(String name) {

        for (Contact contact : myContacts) {

            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void printContact() {
        System.out.println("Contact List:");


        int index = 1;
        for (Contact contact : myContacts) {
            System.out.println(index + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
            index++;
        }
    }
}
