package com.sam.app.db;

//Copyright 2012-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
//Licensed under the Apache License, Version 2.0.


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

public class UserSecurityAPITable {

	private static final Regions Region=Regions.AP_SOUTH_1;
	private static final String KEY="AKIAJNVJDSRSMRNVUF3A";
	private static final String KEYVALUE="jzRnH/6rv5PjGOD9y1ZU6Nk+KBSpTmZRDM+8O2Yv";
	static AWSCredentials awsCredentials=new BasicAWSCredentials(KEY,KEYVALUE);
	static  AmazonDynamoDB client=AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Region).build();
	static   DynamoDB dynamoDB = new DynamoDB(client);

 static String tableName = "TestTable";

 public static void main(String[] args) throws Exception {

     createExampleTable();
    /* listMyTables();
     getTableInformation();
     updateExampleTable();

     deleteExampleTable();*/
 }

 static void createExampleTable() {

     try {

         List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
         attributeDefinitions.add(new AttributeDefinition().withAttributeName("Id").withAttributeType("N"));

         List<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
         keySchema.add(new KeySchemaElement().withAttributeName("Id").withKeyType(KeyType.HASH)); // Partition
                                                                                                  // key

         CreateTableRequest request = new CreateTableRequest().withTableName(tableName).withKeySchema(keySchema)
             .withAttributeDefinitions(attributeDefinitions).withProvisionedThroughput(
                 new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(6L));

         System.out.println("Issuing CreateTable request for " + tableName);
         Table table = dynamoDB.createTable(request);

         System.out.println("Waiting for " + tableName + " to be created...this may take a while...");
         table.waitForActive();

         getTableInformation();

     }
     catch (Exception e) {
         System.err.println("CreateTable request failed for " + tableName);
         System.err.println(e.getMessage());
     }

 }

 static void listMyTables() {

     TableCollection<ListTablesResult> tables = dynamoDB.listTables();
     Iterator<Table> iterator = tables.iterator();

     System.out.println("Listing table names");

     while (iterator.hasNext()) {
         Table table = iterator.next();
         System.out.println(table.getTableName());
     }
 }

 static void getTableInformation() {

     System.out.println("Describing " + tableName);

     TableDescription tableDescription = dynamoDB.getTable(tableName).describe();
     System.out.format(
         "Name: %s:\n" + "Status: %s \n" + "Provisioned Throughput (read capacity units/sec): %d \n"
             + "Provisioned Throughput (write capacity units/sec): %d \n",
         tableDescription.getTableName(), tableDescription.getTableStatus(),
         tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
         tableDescription.getProvisionedThroughput().getWriteCapacityUnits());
 }

 static void updateExampleTable() {

     Table table = dynamoDB.getTable(tableName);
     System.out.println("Modifying provisioned throughput for " + tableName);

     try {
         table.updateTable(new ProvisionedThroughput().withReadCapacityUnits(6L).withWriteCapacityUnits(7L));

         table.waitForActive();
     }
     catch (Exception e) {
         System.err.println("UpdateTable request failed for " + tableName);
         System.err.println(e.getMessage());
     }
 }

 static void deleteExampleTable() {

     Table table = dynamoDB.getTable(tableName);
     try {
         System.out.println("Issuing DeleteTable request for " + tableName);
         table.delete();

         System.out.println("Waiting for " + tableName + " to be deleted...this may take a while...");

         table.waitForDelete();
     }
     catch (Exception e) {
         System.err.println("DeleteTable request failed for " + tableName);
         System.err.println(e.getMessage());
     }
 }

}
