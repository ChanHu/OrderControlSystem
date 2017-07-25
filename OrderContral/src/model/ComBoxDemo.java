package model;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class ComBoxDemo extends JFrame
{
JComboBox computer; //主类别下拉框
JComboBox fittings; //配件下拉框

public ComBoxDemo()
{
super("ComBoxDemo");
this.setLayout(null);

computer=new JComboBox(new String[]{"", "联想电脑", "华硕笔记本", "IBM笔记本"});
fittings = new JComboBox();

//设置两个下拉框的位置和大小
computer.setBounds(100, 40, 100, 25);
fittings.setBounds(100, 80, 100, 25);

//添加事件监听器
computer.addItemListener(new ItemListener()
{
//设置几组常量保存各电脑品牌的配件信息
private final String[] ITEM_LX = {"联想CPU", "联想内存", "联想显示器"};
private final String[] ITEM_HS = {"华硕CPU", "华硕内存", "华硕液晶屏"};
private final String[] ITEM_IBM = {"IBMCPU", "IBM内存", "IBM液晶屏"};

//开始itemStateChanged方法，该方法在选择一台电脑时自动调用
public void itemStateChanged(ItemEvent e) {
//首先获得选择的电脑品牌的索引号
int index = computer.getSelectedIndex();
//将配件下拉框中的所有项移除
fittings.removeAllItems();

//判断所选的电脑品牌
switch (index)
{
case 1:  //联想电脑
addItems(ITEM_LX);
break;
case 2:  //华硕笔记本
addItems(ITEM_HS);
break;
case 3:  //IBM笔记本
addItems(ITEM_IBM);
break;
default: //其它情况
break;
}
} // itemStateChanged()方法结束

//该方法将指定的字符串数组当中的内容添加到配件下拉列表中
private void addItems(String[] s)
{
int sLen = s.length;

if (sLen == 0)
{
return;
}

for (int i=0; i<sLen; i++)
{
fittings.addItem(s[i]);
}
} // addItems()方法结束
}); /* 事件监听添加完成 */

//初始化窗口
this.add(computer);
this.add(fittings);
this.setBounds(240, 200, 320, 240);
this.setVisible(true);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

//主函数
public static void main(String[] args)
{
new ComBoxDemo();
}
}



//
////在JTable中设置某列为下拉列表方式：
//
//TableColumn tc=this.getColumn(0);// 取到一列
//JComboBox cbx = new JComboBox(new String[] {"a","b","c"});// 建立下拉列表
//TableCellEditor tce=new DefaultCellEditor(cbx);// 创建编辑器
//tc.setCellEditor(tce);// 设置编辑器
