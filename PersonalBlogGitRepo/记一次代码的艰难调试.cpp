//先上C++代码,留作日后的念想.......<无语>
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
		if(txt[i]==' ')continue;//跳过空格
		text[j++]=txt[i];
	}while(txt[i++]!=NULL);
	cout<<"原来的字符串(此时已经转化为Char[]类型)"<<text<<endl;
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
					count++;//控制字符压入位置
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
	cout<<"以下是栈内数据:"<<endl;
	cout<<"servername:";
	PrintCharacter(DealCharacter(&servername));
	cout<<"domain:";
	PrintCharacter(DealCharacter(&domain));
	cout<<"port:";
	PrintCharacter(DealCharacter(&port));
	return 1;
}
/*****以下是为这堆代码写的日志*****************/
/****************************************************************************************************************************/
/*
我们的作业之一就是解析一段字符串,
具体而言,就是把servername 之后= 后的值解析出来
之前写了一些质量不是很高的代码,我的优化代码
(根据思路原来以为很简单,居然调了2个多小时)
具体思路,逐一提取string里的字符,当遇到'='时,之后的字符逐一压入栈内,直到遇到'\n'停止
bug及原因:string内的'='的值与char的'='值不相等,可能是编码格式的问题
解决方案,将string 转化为char[]
*/
/*遇到的bug:(及其难调)
解决方案:我把每个字符的ACSII列出来之后,总算解决了所有的问题,\n 的问题,'='的问题统统迎刃而解,
位操作调bug的最好方式之一就是列出所有字符的ascII码.......
最后还遇到一个编译器本身的问题,只能这么解释了,在选择表达式中判断 char == ascII 居然不起作用
最后还是被我解决了,重新定义了一个int整形,接受它的ACSII,......
没想到最后还是有bug,定义的函数没有传地址,改为 stack * 之后,又改了好久(一直没发现指针必须用 -> 访问,而不是' .  '
到最终...只能是无语了
*/
/****************************************************************************************************************************/