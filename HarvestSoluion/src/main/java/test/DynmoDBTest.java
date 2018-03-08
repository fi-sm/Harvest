package test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynmoDBTest {


	private static final Regions Region=Regions.AP_SOUTH_1;
	private static final String KEY="AKIAJ4G7B6GW23TNUDVA";
	private static final String KEYVALUE="pObORTYir2Js/I72x9+hamHinFfmBPIPFo7BszSz";
	
	public static void main(String[] args) {
	   
    	 AWSCredentials awsCredentials=null;
    	 AmazonDynamoDB  client=null;
		try{

	    	awsCredentials=new BasicAWSCredentials(KEY,KEYVALUE);
			client=AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Region).build();
	    	System.out.println("s3client:"+client);
	    	DynamoDB dynamoDB = new DynamoDB(client);
	    	System.out.println(dynamoDB);
	    	
	    }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }

	}

}
