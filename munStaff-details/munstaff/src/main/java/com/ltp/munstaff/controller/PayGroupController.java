package com.ltp.munstaff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltp.munstaff.entity.PayGroup;
import com.ltp.munstaff.services.PayGroupService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
@RequestMapping("/mundial")
public class PayGroupController {

  PayGroupService payGroupService;

  @PostMapping("/paygroup")
  public ResponseEntity<PayGroup> savePayGroup(@RequestBody PayGroup entity, @RequestParam(required = false) Long id) {
    // TODO: process POST request

    return new ResponseEntity<>(payGroupService.savePayGroup(entity), HttpStatus.CREATED);
  };
};
