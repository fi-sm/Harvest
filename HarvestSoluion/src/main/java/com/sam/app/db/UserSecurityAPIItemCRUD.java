package com.sam.app.db;

//Copyright 2012-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
//Licensed under the Apache License, Version 2.0.


import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.sam.app.dto.AppCommonBean;
import com.sam.app.dto.AppCommonDynamoDB;

public class UserSecurityAPIItemCRUD {

	private static final Regions Region=Regions.AP_SOUTH_1;
	private static final String KEY="AKIAJNVJDSRSMRNVUF3A";
	private static final String KEYVALUE="jzRnH/6rv5PjGOD9y1ZU6Nk+KBSpTmZRDM+8O2Yv";
	static AWSCredentials awsCredentials=new BasicAWSCredentials(KEY,KEYVALUE);
	static  AmazonDynamoDB client=AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Region).build();
	static   DynamoDB dynamoDB = new DynamoDB(client);

  

 public static void main(String[] args) throws IOException {
	 UserSecurityAPIItemCRUD userSecurityAPIItemCRUD=new UserSecurityAPIItemCRUD();
	 AppCommonDynamoDB appCommonDynamoDB=new AppCommonDynamoDB();
	 appCommonDynamoDB.setTableName("User_Master");
	// userSecurityAPIItemCRUD.createItems(appCommonDynamoDB);
	 AppCommonBean AppCommonBean=new AppCommonBean();
    userSecurityAPIItemCRUD.retrieveUserDetailByLoginID(AppCommonBean);

     // Perform various updates.
     //updateMultipleAttributes();
     //updateAddNewAttribute();
    // updateExistingAttributeConditionally();

     // Delete the item.
   //  deleteItem();

 }

 public  void createItems(AppCommonDynamoDB appCommonDynamoDB) {
	 System.out.println("dynamoDB*************:"+dynamoDB);

     Table table = dynamoDB.getTable(appCommonDynamoDB.getTableName());
     try {

         Item item = new Item().withPrimaryKey("Id", 120).withString("Title", "Book 120 Title")
             .withString("ISBN", "333-1111111111")
             .withStringSet("Authors", new HashSet<String>(Arrays.asList("Author12", "Author22")))
             .withNumber("Price", 20).withString("Dimensions", "8.5x11.0x.75").withNumber("PageCount", 500)
             .withBoolean("InPublication", false).withString("ProductCategory", "Book");
         table.putItem(item);

         item = new Item().withPrimaryKey("Id", 121).withString("Title", "Book 121 Title")
             .withString("ISBN", "121-1111111111")
             .withStringSet("Authors", new HashSet<String>(Arrays.asList("Author21", "Author 22")))
             .withNumber("Price", 20).withString("Dimensions", "8.5x11.0x.75").withNumber("PageCount", 500)
             .withBoolean("InPublication", true).withString("ProductCategory", "Book");
         table.putItem(item);
         System.out.println("created");

     }
     catch (Exception e) {
    	 
         System.err.println("Create items failed.");
         System.err.println(e.getMessage());
         e.printStackTrace();

     }
 }

 public  String retrieveUserDetailByLoginID(AppCommonBean appCommonBean) {
     Table table = dynamoDB.getTable("UserMaster");
     String resultString=null;
     
     try {
            System.out.println("Login ID::"+appCommonBean.getLoginid());
         Item item = table.getItem("loginid", appCommonBean.getLoginid());
           // Item item = table.getItem("id", 1);
          //  Item item = table.getItem("loginid", "samarjeet");
         System.out.println("Printing item after retrieving it....");
         System.out.println(item.toJSON());
         resultString=item.toJSON();
     }
     catch (Exception e) {
         System.err.println("GetItem failed.");
         System.err.println(e.getMessage());
     }
return resultString;
 }

 public  void updateAddNewAttribute(AppCommonDynamoDB appCommonDynamoDB) {
     Table table = dynamoDB.getTable(appCommonDynamoDB.getTableName());

     try {

         UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Id", 121)
             .withUpdateExpression("set #na = :val1").withNameMap(new NameMap().with("#na", "NewAttribute"))
             .withValueMap(new ValueMap().withString(":val1", "Some value")).withReturnValues(ReturnValue.ALL_NEW);

         UpdateItemOutcome outcome = table.updateItem(updateItemSpec);

         // Check the response.
         System.out.println("Printing item after adding new attribute...");
         System.out.println(outcome.getItem().toJSONPretty());

     }
     catch (Exception e) {
         System.err.println("Failed to add new attribute in " + appCommonDynamoDB.getTableName());
         System.err.println(e.getMessage());
     }
 }

 public void updateMultipleAttributes(AppCommonDynamoDB appCommonDynamoDB) {

     Table table = dynamoDB.getTable(appCommonDynamoDB.getTableName());

     try {

         UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Id", 120)
             .withUpdateExpression("add #a :val1 set #na=:val2")
             .withNameMap(new NameMap().with("#a", "Authors").with("#na", "NewAttribute"))
             .withValueMap(
                 new ValueMap().withStringSet(":val1", "Author YY", "Author ZZ").withString(":val2", "someValue"))
             .withReturnValues(ReturnValue.ALL_NEW);

         UpdateItemOutcome outcome = table.updateItem(updateItemSpec);

         // Check the response.
         System.out.println("Printing item after multiple attribute update...");
         System.out.println(outcome.getItem().toJSONPretty());

     }
     catch (Exception e) {
         System.err.println("Failed to update multiple attributes in " + appCommonDynamoDB.getTableName());
         System.err.println(e.getMessage());

     }
 }

 public void updateExistingAttributeConditionally(AppCommonDynamoDB appCommonDynamoDB) {

     Table table = dynamoDB.getTable(appCommonDynamoDB.getTableName());

     try {

         // Specify the desired price (25.00) and also the condition (price =
         // 20.00)

         UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Id", 120)
             .withReturnValues(ReturnValue.ALL_NEW).withUpdateExpression("set #p = :val1")
             .withConditionExpression("#p = :val2").withNameMap(new NameMap().with("#p", "Price"))
             .withValueMap(new ValueMap().withNumber(":val1", 25).withNumber(":val2", 20));

         UpdateItemOutcome outcome = table.updateItem(updateItemSpec);

         // Check the response.
         System.out.println("Printing item after conditional update to new attribute...");
         System.out.println(outcome.getItem().toJSONPretty());

     }
     catch (Exception e) {
         System.err.println("Error updating item in " + appCommonDynamoDB.getTableName());
         System.err.println(e.getMessage());
     }
 }

 public void deleteItem(AppCommonDynamoDB appCommonDynamoDB) {

     Table table = dynamoDB.getTable(appCommonDynamoDB.getTableName());

     try {

         DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("Id", 120)
             .withConditionExpression("#ip = :val").withNameMap(new NameMap().with("#ip", "InPublication"))
             .withValueMap(new ValueMap().withBoolean(":val", false)).withReturnValues(ReturnValue.ALL_OLD);

         DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);

         // Check the response.
         System.out.println("Printing item that was deleted...");
         System.out.println(outcome.getItem().toJSONPretty());

     }
     catch (Exception e) {
         System.err.println("Error deleting item in " + appCommonDynamoDB.getTableName());
         System.err.println(e.getMessage());
     }
 }
}
