package cn.edu.zucc.ordercontrol.ui;

import javax.swing.JComboBox;

import cn.edu.zucc.booklib.model.BeanReaderType;

public class ProductAdd {
	//��ȡ���������Ϣ
			String[] strTypes=new String[this.readerTypeMap_name.size()+1];
			strTypes[0]="";
			java.util.Iterator<BeanReaderType> itRt=this.readerTypeMap_name.values().iterator();
			int i=1;
			while(itRt.hasNext()){
				strTypes[i]=itRt.next().getReaderTypeName();
				i++;
			}
			cmbReadertype=new JComboBox(strTypes);
			workPane.add(cmbReadertype);
}
