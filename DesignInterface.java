import com.lyhux.jsonparse.JsonArray;
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
		
//		String jsonstr = "{\"name\":[{\"name2\":\"value2\"}]}";
		
	
		
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
		
		
		String jsonstr1 = "{\"web-app\": {"
				 + "  \"servlet\": [   "
				 + "    {"
				 + "      \"servlet-name\": \"cofaxCDS\","
				 + "      \"servlet-class\": \"org.cofax.cds.CDSServlet\","
				 + "      \"init-param\": {"
				 + "        \"configGlossary:installationAt\": \"Philadelphia, PA\","
				 + "        \"configGlossary:adminEmail\": \"ksm@pobox.com\","
				 + "        \"configGlossary:poweredBy\": \"Cofax\","
				 + "        \"configGlossary:poweredByIcon\": \"/images/cofax.gif\","
				 + "        \"configGlossary:staticPath\": \"/content/static\","
				 + "        \"templateProcessorClass\": \"org.cofax.WysiwygTemplate\","
				 + "        \"templateLoaderClass\": \"org.cofax.FilesTemplateLoader\","
				 + "        \"templatePath\": \"templates\","
				 + "        \"templateOverridePath\": \"\","
				 + "        \"defaultListTemplate\": \"listTemplate.htm\","
				 + "        \"defaultFileTemplate\": \"articleTemplate.htm\","
				 + "        \"useJSP\": false,"
				 + "        \"jspListTemplate\": \"listTemplate.jsp\","
				 + "        \"jspFileTemplate\": \"articleTemplate.jsp\","
				 + "        \"cachePackageTagsTrack\": 200,"
				 + "        \"cachePackageTagsStore\": 200,"
				 + "        \"cachePackageTagsRefresh\": 60,"
				 + "        \"cacheTemplatesTrack\": 100,"
				 + "        \"cacheTemplatesStore\": 50,"
				 + "        \"cacheTemplatesRefresh\": 15,"
				 + "        \"cachePagesTrack\": 200,"
				 + "        \"cachePagesStore\": 100,"
				 + "        \"cachePagesRefresh\": 10,"
				 + "        \"cachePagesDirtyRead\": 10,"
				 + "        \"searchEngineListTemplate\": \"forSearchEnginesList.htm\","
				 + "        \"searchEngineFileTemplate\": \"forSearchEngines.htm\","
				 + "        \"searchEngineRobotsDb\": \"WEB-INF/robots.db\","
				 + "        \"useDataStore\": true,"
				 + "        \"dataStoreClass\": \"org.cofax.SqlDataStore\","
				 + "        \"redirectionClass\": \"org.cofax.SqlRedirection\","
				 + "        \"dataStoreName\": \"cofax\","
				 + "        \"dataStoreDriver\": \"com.microsoft.jdbc.sqlserver.SQLServerDriver\","
				 + "        \"dataStoreUrl\": \"jdbc:microsoft:sqlserver://LOCALHOST:1433;DatabaseName=goon\","
				 + "        \"dataStoreUser\": \"sa\","
				 + "        \"dataStorePassword\": \"dataStoreTestQuery\","
				 + "        \"dataStoreTestQuery\": \"SET NOCOUNT ON;select test='test';\","
				 + "        \"dataStoreLogFile\": \"/usr/local/tomcat/logs/datastore.log\","
				 + "        \"dataStoreInitConns\": 10,"
				 + "        \"dataStoreMaxConns\": 100,"
				 + "        \"dataStoreConnUsageLimit\": 100,"
				 + "        \"dataStoreLogLevel\": \"debug\","
				 + "        \"maxUrlLength\": 500}},"
				 + "    {"
				 + "      \"servlet-name\": \"cofaxEmail\","
				 + "      \"servlet-class\": \"org.cofax.cds.EmailServlet\","
				 + "      \"init-param\": {"
				 + "      \"mailHost\": \"mail1\","
				 + "      \"mailHostOverride\": \"mail2\"}},"
				 + "    {"
				 + "      \"servlet-name\": \"cofaxAdmin\","
				 + "      \"servlet-class\": \"org.cofax.cds.AdminServlet\"},"
				 + " "
				 + "    {"
				 + "      \"servlet-name\": \"fileServlet\","
				 + "      \"servlet-class\": \"org.cofax.cds.FileServlet\"},"
				 + "    {"
				 + "      \"servlet-name\": \"cofaxTools\","
				 + "      \"servlet-class\": \"org.cofax.cms.CofaxToolsServlet\","
				 + "      \"init-param\": {"
				 + "        \"templatePath\": \"toolstemplates/\","
				 + "        \"log\": 1,"
				 + "        \"logLocation\": \"/usr/local/tomcat/logs/CofaxTools.log\","
				 + "        \"logMaxSize\": \"\","
				 + "        \"dataLog\": 1,"
				 + "        \"dataLogLocation\": \"/usr/local/tomcat/logs/dataLog.log\","
				 + "        \"dataLogMaxSize\": \"\","
				 + "        \"removePageCache\": \"/content/admin/remove?cache=pages&id=\","
				 + "        \"removeTemplateCache\": \"/content/admin/remove?cache=templates&id=\","
				 + "        \"fileTransferFolder\": \"/usr/local/tomcat/webapps/content/fileTransferFolder\","
				 + "        \"lookInContext\": 1,"
				 + "        \"adminGroupID\": 4,"
				 + "        \"betaServer\": true}}],"
				 + "  \"servlet-mapping\": {"
				 + "    \"cofaxCDS\": \"/\","
				 + "    \"cofaxEmail\": \"/cofaxutil/aemail/*\","
				 + "    \"cofaxAdmin\": \"/admin/*\","
				 + "    \"fileServlet\": \"/static/*\","
				 + "    \"cofaxTools\": \"/tools/*\"},"
				 + " "
				 + "  \"taglib\": {"
				 + "    \"taglib-uri\": \"cofax.tld\","
				 + "    \"taglib-location\": \"/WEB-INF/tlds/cofax.tld\"}}}";
		
		JsonParse jp = new JsonParse(jsonstr);
		
		jp.displayTokens();
		
		
		JsonObject jo = jp.parse();
		
		System.out.println(jo);
		
		
		
		JsonParse jp1 = new JsonParse(jsonstr1);
		
		jp.displayTokens();
		
		
		JsonObject jo1 = jp1.parse();
		
		System.out.println(jo1);
		
		
		JsonObject myJsonObject = new JsonObject();
		
		JsonArray ja = new JsonArray();
		ja.add(new JsonValue("line1"));
		ja.add(new JsonValue(7728837.0));
		
		JsonObject my1 = new JsonObject();
		my1.add("mykey2", new JsonValue("value2"));
		ja.add(new JsonValue(my1));
		
		JsonValue jv = new JsonValue(ja);
		
		myJsonObject.add("mykey", jv);
		
		System.out.println(myJsonObject.toString());

		
		
	}

}
