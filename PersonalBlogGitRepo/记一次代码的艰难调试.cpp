//����C++����,�����պ������.......<����>
#include <iostream>
#include <stack>
#include<string>
using namespace std;
stack<char> DealCharacter(stack<char> *stk)
{
	stack<char> stkNew;
	while(!stk->empty())
	{
		char tmp=stk->top();
		int d=tmp;
		if(d==61){break;}
		stkNew.push(tmp);
		stk->pop();
		
	}
	return stkNew;
}
void PrintCharacter(stack<char> que)
{
	while(!que.empty())
	{
		printf("[%c]",que.top());
		que.pop();
	}
	cout<<endl;
}
int main()
{
	int i=0,j=0;
	stack<char> servername;
	stack<char> domain;
	stack<char> port;
	int sw=0;
	int count=0;
	string txt = "servername = uwenya\n domain = www.uwenya.cc\n port = 6666\n";
	char text[1024];
	do
	{
		if(txt[i]==' ')continue;//�����ո�
		text[j++]=txt[i];
	}while(txt[i++]!=NULL);
	cout<<"ԭ�����ַ���(��ʱ�Ѿ�ת��ΪChar[]����)"<<text<<endl;
	i=0;
	while(text[i]!=NULL)
	{
	//printf("%d     %c      %d\n",i,text[i],text[i]);
		switch(count)
		{
		case 0:{
				if(text[i]!=10){
					servername.push(text[i]);
				}if(text[i]==10)
				{
					count++;//�����ַ�ѹ��λ��
				}
			   }break;
			case 1:{
					if(text[i]!=10){
					domain.push(text[i]);
				}if(text[i]==10)
				{
					count++;
				}
				   }break;
			case 2:{
					if(text[i]!=10){
					port.push(text[i]);
				}

				   }break;
		}
		
		i++;
	}

	/*cout<<servername.size()<<endl;
	cout<<domain.size()<<endl;
	cout<<port.size()<<endl;*/
	//DealCharacter(&servername);
	cout<<"������ջ������:"<<endl;
	cout<<"servername:";
	PrintCharacter(DealCharacter(&servername));
	cout<<"domain:";
	PrintCharacter(DealCharacter(&domain));
	cout<<"port:";
	PrintCharacter(DealCharacter(&port));
	return 1;
}
/*****������Ϊ��Ѵ���д����־*****************/
/****************************************************************************************************************************/
/*
���ǵ���ҵ֮һ���ǽ���һ���ַ���,
�������,���ǰ�servername ֮��= ���ֵ��������
֮ǰд��һЩ�������ǺܸߵĴ���,�ҵ��Ż�����
(����˼·ԭ����Ϊ�ܼ�,��Ȼ����2����Сʱ)
����˼·,��һ��ȡstring����ַ�,������'='ʱ,֮����ַ���һѹ��ջ��,ֱ������'\n'ֹͣ
bug��ԭ��:string�ڵ�'='��ֵ��char��'='ֵ�����,�����Ǳ����ʽ������
�������,��string ת��Ϊchar[]
*/
/*������bug:(�����ѵ�)
�������:�Ұ�ÿ���ַ���ACSII�г���֮��,�����������е�����,\n ������,'='������ͳͳӭ�ж���,
λ������bug����÷�ʽ֮һ�����г������ַ���ascII��.......
�������һ�����������������,ֻ����ô������,��ѡ����ʽ���ж� char == ascII ��Ȼ��������
����Ǳ��ҽ����,���¶�����һ��int����,��������ACSII,......
û�뵽�������bug,����ĺ���û�д���ַ,��Ϊ stack * ֮��,�ָ��˺þ�(һֱû����ָ������� -> ����,������' .  '
������...ֻ����������
*/
/****************************************************************************************************************************/