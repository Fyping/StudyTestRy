#include<stdio.h>
/**
author:fyping
time:20170616
function:把从firefox 上复制下来的请求头信息格式化成python 爬虫需要用到的请求头字典
 本来是打算用自己熟悉的语言写的，但是觉得那样根本没有挑战性，不符合我的geek性格，于是重新捡起
 c 语言，用纯c语言写这样一个脚本完成这些功能 
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
