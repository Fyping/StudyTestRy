#include<stdio.h>
/**
author:fyping
time:20170616
function:�Ѵ�firefox �ϸ�������������ͷ��Ϣ��ʽ����python ������Ҫ�õ�������ͷ�ֵ�
 �����Ǵ������Լ���Ϥ������д�ģ����Ǿ�����������û����ս�ԣ��������ҵ�geek�Ը��������¼���
 c ���ԣ��ô�c����д����һ���ű������Щ���� 
*/ 
int main(int arg,char *args[]){
	char ch;
	FILE * input = fopen("requestHeadInformation.md","r");
	FILE * out   = fopen("parseFile","w+");
	char line[2014] = {0};
	int i=0;
	fprintf(out,"headers={");
	while((ch=getc(input))!=EOF){
		line[i++]=ch;
		if(ch=='\n'){
//			printf("%s",line);
			int j=0,k=0,v=0;
			char key[30]={0};
			char *pKey=key;
			char value[1024]={0};
			char *pValue=value;
			bool flag = false;
			for(;j<i-1;j++){
				
				if(line[j]==':'){
					flag=true;
					continue;
				}
				if(!flag){
					key[k++]=line[j];
				}
				if(flag){
					value[v++]=line[j];
				}
			}
			printf("%s\n",key);
			printf("%s\n",value);
			fprintf(out,"\"%s\":\"%s\",\n",key,value);
			i=0;
		}
	}
	fprintf(out,"\"\":\"\"}");
	out=NULL;
	input= NULL;
}
