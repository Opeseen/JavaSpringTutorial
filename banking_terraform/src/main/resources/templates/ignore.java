// package templates;



  // @Override
  // public List<Transactions> getUserTransactionHistory(String Id){
  //   List<Transactions> trans = transactionRepository.findByUsersId(Long.parseLong(Id));
  //   ObjectMapper mapper = new ObjectMapper(); 
  //   try {
  //     String jsonResult = mapper.writeValueAsString(trans);
  //     System.out.println(jsonResult);
  //   } catch (JsonProcessingException e) {
  //     // TODO Auto-generated catch block
  //     e.printStackTrace();
  //   }
  //   return transactionRepository.findByUsersId(Long.parseLong(Id));
  // }