import com.lyhux.jsonparse.JsonObject;
import com.lyhux.jsonparse.JsonParse;
import com.lyhux.jsonparse.JsonParseException;
import com.lyhux.jsonparse.JsonValue;

public class DesignInterface {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//		String json = "{\"name\":\"vaul\"}";
//		
//		char[] p = json.toCharArray();
//		
//		// char[] p1 = p+10;
//		
//		System.out.println(p);
//		
//		JsonParse jp = new JsonParse("{"
//+    "\"glossary\": {"
//+	"\"title\": \"example glossary\","
//+		"\"GlossDiv\": {"
// +        "   \"title\": \"S\","
//	+	"	\"GlossList\": {"
//     +    "       \"GlossEntry\": {"
//      +    "          \"ID\": \"SGML\","
//		+	"		\"SortAs\": \"SGML\","
//		+	"		\"GlossTerm\": \"Standard Generalized Markup Language\","
//		+	"		\"Acronym\": \"SGML\","
//		+	"		\"Abbrev\": \"ISO 8879:1986\","
//		+	"		\"GlossDef\": {"
//         +    "           \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\","
//			+	"		\"GlossSeeAlso\": [\"GML\", \"XML\"]"
//             +   "    },"
//				+"	\"GlossSee\": \"markup\""
//              + " }"
//           +" }"
//       +" }"
//  +"  }"
//+"}");
//		
//		
//		
//		jp.displayTokens();
//		
//		
//		
//		 jp = new JsonParse("{\"widget\": {"
//				+ "    \"debug\": \"on\","
//				+ "    \"window\": {"
//				+ "        \"title\": \"Sample Konfabulator Widget\","
//				+ "        \"name\": \"main_window\","
//				+ "        \"width\": 501,"
//				+ "        \"height\": 502"
//				+ "    },"
//				+ "    \"image\": {"
//				+ "        \"src\": \"Images/Sun.png\","
//				+ "        \"name\": \"sun1\","
//				+ "        \"hOffset\": 250,"
//				+ "        \"vOffset\": 251,"
//				+ "        \"alignment\": \"center\""
//				+ "    },"
//				+ "    \"text\": {"
//				+ "        \"data\": \"Click Here\","
//				+ "        \"size\": 36,"
//				+ "        \"style\": \"bold\","
//				+ "        \"name\": \"text1\","
//				+ "        \"hOffset\": 250,"
//				+ "        \"vOffset\": 100,"
//				+ "        \"alignment\": \"center\","
//				+ "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\""
//				+ "    }"
//				+ "}}");
		
		//String jsonstr = "{\"name\":[{\"name2\":\"value2\"}]}";
		
		
//		String jsonstr = "{\"widget\": {"
//		+ "    \"debug\": \"on\","
//		+ "    \"window\": {"
//		+ "        \"title\": \"Sample Konfabulator Widget\","
//		+ "        \"name\": \"main_window\","
//		+ "        \"width\": 501,"
//		+ "        \"height\": 502"
//		+ "    },"
//		+ "    \"image\": {"
//		+ "        \"src\": \"Images/Sun.png\","
//		+ "        \"name\": \"sun1\","
//		+ "        \"hOffset\": 250,"
//		+ "        \"vOffset\": 251,"
//		+ "        \"alignment\": \"center\""
//		+ "    },"
//		+ "    \"text\": {"
//		+ "        \"data\": \"Click Here\","
//		+ "        \"size\": 36,"
//		+ "        \"style\": \"bold\","
//		+ "        \"name\": \"text1\","
//		+ "        \"hOffset\": 250,"
//		+ "        \"vOffset\": 100,"
//		+ "        \"alignment\": \"center\","
//		+ "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\""
//		+ "    }"
//		+ "}}";
		
		
		String jsonstr = "{\"widget\": {"
				+ "    \"debug\": \"on\","
				+ "    \"window\": {"
				+ "        \"title\": \"Sample Konfabulator Widget\","
				+ "        \"name\": \"main_window\","
				+ "        \"width\": 501,"
				+ "        \"height\": 502"
				+ "    },"
				+ "    \"image\": {"
				+ "        \"src\": \"Images/Sun.png\","
				+ "        \"name\": \"sun1\","
				+ "        \"hOffset\": 250,"
				+ "        \"vOffset\": 251,"
				+ "        \"alignment\": \"center\""
				+ "    },"
				+ "    \"text\": {"
				+ "        \"data\": \"Click Here\","
				+ "        \"size\": 36,"
				+ "        \"style\": \"bold\","
				+ "        \"name\": \"text1\","
				+ "        \"hOffset\": 250,"
				+ "        \"vOffset\": 100,"
				+ "        \"alignment\": \"center\","
				+ "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\""
				+ "    }"
				+ "}}";
		
		JsonParse jp = new JsonParse(jsonstr);
		
		jp.displayTokens();
		
		
		JsonObject jo = jp.parse();
		jo.display();
		
		JsonValue jv = jo.get("widget");
		
		jv.display(0);
		
		// System.out.println(jo);
		
	}

}
