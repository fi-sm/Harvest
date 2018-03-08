package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.ams.entity.ATMRequestMessageEntity;

public class TestClass {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		
		ATMRequestMessageEntity atmRequest=new ATMRequestMessageEntity();
		atmRequest.setTermid("DC00021 #");
		atmRequest.setMsgtype("N");
		atmRequest.setMsglen(333);
		atmRequest.setMsgxdate("20171019");
		atmRequest.setMsgxtime("020623");
		atmRequest.setMsgdata(" <note>\n" + 
				"       <to>Tove</to>\n" + 
				"       <from>Jani</from>\n" + 
				"       <heading>Reminder</heading>\n" + 
				"       <body>Don't forget me this weekend!</body>\n" + 
				"   </note>");
		
		
		ObjectMapper mapper = new ObjectMapper();
		// Convert object to JSON string
					String jsonInString = mapper.writeValueAsString(atmRequest);
					System.out.println(jsonInString);

	}

}
