package com.ltp.munstaff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltp.munstaff.entity.PayGroup;
import com.ltp.munstaff.response.success.SuccessResponse;
import com.ltp.munstaff.services.PayGroupService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/mundial")
public class PayGroupController {

  PayGroupService payGroupService;

  @PostMapping("/paygroup")
  public ResponseEntity<PayGroup> saveEntity(@RequestBody PayGroup entity, @RequestParam(required = false) Long id) {
    return new ResponseEntity<>(payGroupService.savePayGroup(entity), HttpStatus.CREATED);
  };

  @GetMapping("/paygroup/{id}")
  public ResponseEntity<PayGroup> getEntity(@PathVariable Long id) {
    return new ResponseEntity<>(payGroupService.getPayGroup(id), HttpStatus.OK);
  };

  @GetMapping("/paygroup/all")
  public ResponseEntity<?> getAllEntity() {
    List<PayGroup> entity = payGroupService.getAllPayGroup();
    SuccessResponse successDetails = new SuccessResponse(true, entity.size(), entity, null);
    return new ResponseEntity<>(successDetails, HttpStatus.OK);
  };

  @PutMapping("paygroup/{id}")
  public ResponseEntity<PayGroup> updateEntity(@PathVariable Long id, @RequestBody PayGroup entity) {
    return new ResponseEntity<>(payGroupService.updatePayGroup(entity, id), HttpStatus.OK);
  };

  @PutMapping("paygroup/{payGroupId}/employee/{employeeId}")
  public ResponseEntity<PayGroup> addEmployeeToPayGroup(@PathVariable Long payGroupId, @PathVariable Long employeeId) {
    return new ResponseEntity<>(payGroupService.addEmployeeToPayGroup(employeeId, payGroupId), HttpStatus.OK);
  };

  @DeleteMapping("/paygroup/{id}")
  public ResponseEntity<HttpStatus> deleteEntity(@PathVariable Long id) {
    payGroupService.deletePayGroup(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  };

};
