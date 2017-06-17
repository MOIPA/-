
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author 唐锐117 2017/6/17/15:17
 *
 */

public class demo {
	public static void main(String[] args) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read("src/作业1.xml");
			Element root = doc.getRootElement();
			// int count=0;
			// for(Iterator i = root.elementIterator();i.hasNext();){
			// Element element=(Element) i.next();
			// System.out.println(element.getName()+count++);
			//
			// for(Iterator k = element.attributeIterator();k.hasNext();){
			// Attribute att = (Attribute)k.next();
			// System.out.println(att.getText());
			// }
			//
			// for(Iterator j = element.elementIterator();j.hasNext();){
			// Element element2 = (Element) j.next();
			// System.out.println(element2.getName());
			// }
			// }

			// 测试properties
			Properties pro = new Properties();
			FileOutputStream out = new FileOutputStream("src/reslut.properties");
			ConverIntoPro(root, "",pro,out);
			pro.store(out, null);
			out.close();
			// Do_travels(root,"");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 模拟结果输出
	private static void Do_travels(Element ele, String fatherName) {
		if (ele != null) {
			// 保存节点名
			String nodeName = ele.getName();
			// 先对这个节点的属性遍历一遍
			for (Iterator it = ele.attributeIterator(); it.hasNext();) {
				Attribute att = (Attribute) it.next();
				String info = nodeName + "." + att.getName() + "=" + att.getText();
				System.out.println(fatherName + info);
			}
			// 再输出节点值
			if (!ele.getTextTrim().equals("")) {
				System.out.println(fatherName + nodeName + "=" + ele.getTextTrim());
			}
			// System.out.println();
			// 再遍历子节点属性
			fatherName += nodeName + ".";
			for (Iterator it = ele.elementIterator(); it.hasNext();) {
				Do_travels((Element) it.next(), fatherName);
			}
		}
	}

	// 转换工作

	private static void ConverIntoPro(Element ele, String fatherName,Properties pro,FileOutputStream out) {
		if (ele != null) {
			
			try {
				
				// 测试
				// pro.setProperty("test", "hello_World");
				// pro.store(out, "test");
				// out.close();

				// 保存节点名
				String nodeName = ele.getName();
				
				if(!nodeName.equals("root")){
					// 先对这个节点的属性遍历一遍
					for (Iterator it = ele.attributeIterator(); it.hasNext();) {
						Attribute att = (Attribute) it.next();
						String info = fatherName+nodeName + "." + att.getName();
						pro.setProperty(info, att.getText());

					}
					// 再输出节点值
					if (!ele.getTextTrim().equals("")) {
						pro.setProperty(fatherName + nodeName, ele.getTextTrim());
					}
					fatherName += nodeName + ".";
				}
				
				
				// 再遍历子节点属性
				
				for (Iterator it = ele.elementIterator(); it.hasNext();) {
					ConverIntoPro((Element) it.next(), fatherName,pro,out);
				}


			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
