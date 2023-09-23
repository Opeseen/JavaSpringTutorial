package com.ltp.contacts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.contacts.Constants;
import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id){
        Contact contact;
        try {
            contact = contactService.getContactById(id);
            return new ResponseEntity<Contact>(contact, HttpStatus.OK);
        } catch (NoContactException e) {
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getAllContacts(){
        List<Contact> contacts = contactService.geContacts();
        return new ResponseEntity<List<Contact>>(contacts, null, HttpStatus.OK);
    }
    
    
    @PostMapping("/contact")
    public ResponseEntity<String> createContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(Constants.POST_SUCCESSFUL,HttpStatus.CREATED);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @RequestBody Contact contact){
        try {
            contactService.updateContact(id, contact);
            return new ResponseEntity<Contact>(contactService.getContactById(id), HttpStatus.OK);
        } catch (NoContactException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){
        try {
            contactService.deleteContact(id);
            return new ResponseEntity<HttpStatus>(null, null, HttpStatus.NO_CONTENT);
        } catch (NoContactException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
