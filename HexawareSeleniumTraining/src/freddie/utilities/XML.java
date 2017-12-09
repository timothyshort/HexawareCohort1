package freddie.utilities;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XML {
	
	// This function reads XML and returns double array
	public static String[][] get(String filename) {
		String[][] dataSet = null;
		
		// Create the XML File
		InputSource xmlFile = new InputSource(filename);
		
		// Prepare the XPath settings
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xPath = xpf.newXPath();
		
		try {
			// Define Parent Node & Generate List of Nodes
			NodeList orders = (NodeList) xPath.evaluate("/shoppingcart/order", xmlFile, XPathConstants.NODESET);
			
			// Define Child Nodes
			XPathExpression xItemResult = xPath.compile("itemresult");
			XPathExpression xQty = xPath.compile("qty");
			XPathExpression xCustName = xPath.compile("custname");
			XPathExpression xCustAddress = xPath.compile("custaddress");
			XPathExpression xCustCity = xPath.compile("custcity");
		
			// Define our data structure (rows & columns)
			int rows = orders.getLength();
			int columns = 6;
			dataSet = new String[rows][columns];
			
			// Iterate through XML (based on a parent node)
			for (int i=0; i<rows; i++) {
				// Create a node for each item in node list
				Node order = orders.item(i);
					
					// Dynamically add child nodes to an array
					NodeList children = order.getChildNodes();
					String[] childNodes = new String[children.getLength()];
					for (int j=0; j<children.getLength(); j++) {
						Node child = children.item(j);
						childNodes[j] = child.getTextContent();
					}
					// Add the array to your List<String[]> data structure
				
				// Capture each child node by XPath
				String product = order.getAttributes().item(0).getTextContent();
				String itemResult = xItemResult.evaluate(order, XPathConstants.STRING).toString();
				String qty = xQty.evaluate(order, XPathConstants.STRING).toString();
				String name = xCustName.evaluate(order, XPathConstants.STRING).toString();
				String address = xCustAddress.evaluate(order, XPathConstants.STRING).toString();
				String city = xCustCity.evaluate(order, XPathConstants.STRING).toString();
				
				// System.out.println(product + " " + itemResult + " " + qty + " " + name + " " + address + " ");
				
				// Parameterize into Data Structure
				dataSet[i][0] = product;
				dataSet[i][1] = itemResult;
				dataSet[i][2] = qty;
				dataSet[i][3] = name;
				dataSet[i][4] = address;
				dataSet[i][5] = city;
				
			}
		
		} catch (XPathExpressionException e) {
			System.out.println("COULD NOT READ XPATH EXPRESSION");
			e.printStackTrace();
		}
		
		return dataSet;
	}

}
