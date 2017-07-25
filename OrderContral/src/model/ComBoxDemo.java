package model;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class ComBoxDemo extends JFrame
{
JComboBox computer; //�����������
JComboBox fittings; //���������

public ComBoxDemo()
{
super("ComBoxDemo");
this.setLayout(null);

computer=new JComboBox(new String[]{"", "�������", "��˶�ʼǱ�", "IBM�ʼǱ�"});
fittings = new JComboBox();

//���������������λ�úʹ�С
computer.setBounds(100, 40, 100, 25);
fittings.setBounds(100, 80, 100, 25);

//����¼�������
computer.addItemListener(new ItemListener()
{
//���ü��鳣�����������Ʒ�Ƶ������Ϣ
private final String[] ITEM_LX = {"����CPU", "�����ڴ�", "������ʾ��"};
private final String[] ITEM_HS = {"��˶CPU", "��˶�ڴ�", "��˶Һ����"};
private final String[] ITEM_IBM = {"IBMCPU", "IBM�ڴ�", "IBMҺ����"};

//��ʼitemStateChanged�������÷�����ѡ��һ̨����ʱ�Զ�����
public void itemStateChanged(ItemEvent e) {
//���Ȼ��ѡ��ĵ���Ʒ�Ƶ�������
int index = computer.getSelectedIndex();
//������������е��������Ƴ�
fittings.removeAllItems();

//�ж���ѡ�ĵ���Ʒ��
switch (index)
{
case 1:  //�������
addItems(ITEM_LX);
break;
case 2:  //��˶�ʼǱ�
addItems(ITEM_HS);
break;
case 3:  //IBM�ʼǱ�
addItems(ITEM_IBM);
break;
default: //�������
break;
}
} // itemStateChanged()��������

//�÷�����ָ�����ַ������鵱�е�������ӵ���������б���
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
} // addItems()��������
}); /* �¼����������� */

//��ʼ������
this.add(computer);
this.add(fittings);
this.setBounds(240, 200, 320, 240);
this.setVisible(true);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

//������
public static void main(String[] args)
{
new ComBoxDemo();
}
}



//
////��JTable������ĳ��Ϊ�����б�ʽ��
//
//TableColumn tc=this.getColumn(0);// ȡ��һ��
//JComboBox cbx = new JComboBox(new String[] {"a","b","c"});// ���������б�
//TableCellEditor tce=new DefaultCellEditor(cbx);// �����༭��
//tc.setCellEditor(tce);// ���ñ༭��
