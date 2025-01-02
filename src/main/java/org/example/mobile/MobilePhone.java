package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String MyNumber;

    List<Contact> myContacts = new ArrayList<>();

    public String getMyNumber() {
        return MyNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber) {
        MyNumber = myNumber;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        MyNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (myContacts.contains(contact)) {
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    };

    public boolean updateContact(Contact contact1, Contact contact2) {
        int index = myContacts.indexOf(contact1);
        if (index != -1) {
            myContacts.set(index, contact2);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if(myContacts.contains(contact)) {
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

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }


    public Contact queryContact(String contactName) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null; 
    }


    public void printContact() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }



}
