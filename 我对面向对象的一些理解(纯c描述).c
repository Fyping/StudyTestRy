#include<stdio.h>
#include<string.h>
/*用纯C写的我对于面向对象的理解,
虽然是面向过程的语言,
但是仍然有一点点面向对象的味道*/
typedef struct
{
	char name[30];
	int age;
	char sex[5];
} Person;
typedef struct 
{
	Person teacher;
	char Job[30];
	float salary;
	char subject[10];
} Teacher;
typedef struct 
{
	Person student;
	char Scard[9];//学号
	float avgScore;
	char major[30];
} Student;
typedef struct 
{
	Person worker;
	char Job[30];
	float salary;
	int Is_batch;//是否婚配
	int HunLinOrDanShenC;
}  Worker;
void initPerson(Person *man)
{
	strcpy(man->name,"Fang");
	man->age=20;
	strcpy(man->sex,"Girl");
}
void printPersonInfo(Person man)
{
	printf("我是%s\n我的年龄是%d\n我的性别:%s\n",
		man.name,man.age,man.sex);
}
void initTeacher(Teacher *tech)
{
	strcpy(tech->teacher.name,"FangYanPing");
	tech->teacher.age=23;
	strcpy(tech->teacher.sex,"Boy");
	tech->salary=8000;
	strcpy(tech->Job,"教学");
	strcpy(tech->subject,"Software");
}
void printTeacherInfo(Teacher tech)
{
	printPersonInfo(tech.teacher);
	printf("我的工作是%s\n",tech.Job);
	printf("我的月薪大概是%f\n",tech.salary);
	printf("我所教的科目是%s\n",tech.subject);
}
void initStudent(Student *stu)
{
	strcpy(stu->student.name,"FangYanPing");
	stu->student.age=23;
	strcpy(stu->student.sex,"Boy");
	stu->avgScore=95.00;
	strcpy(stu->major,"software");
	strcpy(stu->Scard,"20150000");
}
void printStudentInfo(Student stu)
{
	printPersonInfo(stu.student);
	printf("我的专业是%s\n",stu.major);
	printf("我的学号是%s\n",stu.Scard);
	printf("我的专业课平均成绩大概是%f\n",stu.avgScore);
}
void initWorker(Worker *work)
{
	strcpy(work->worker.name,"XiJP");
	work->worker.age=43;
	strcpy(work->worker.sex,"Male");
	work->salary=5000.00;
	strcpy(work->Job,"Building");
	work->Is_batch=1;//初始为已婚
	work->HunLinOrDanShenC=5;
}
void printWorkerInfo(Worker work)
{
	printPersonInfo(work.worker);
	printf("我的工种是%s\n",work.Job);
	printf("我的一个月的工资是%f\n",work.salary);
	printf("我的婚姻情况是:");
	if(1==work.Is_batch)
	{printf("已婚\n");
	printf("我已经结婚%d年了!\n",work.HunLinOrDanShenC);}
	else{printf("未婚,至今单身\n");
	printf("我已经单身%d年了,上天啊!赐我一段姻缘把!\n",work.HunLinOrDanShenC);}
}
void StuTest()//运行测试函数
{
	Student t;
	initStudent(&t);
	printStudentInfo(t);
}
void TecTest()//运行测试函数
{
	Teacher t;
	initTeacher(&t);
	printTeacherInfo(t);
}
void WorkTest()
{
	Worker t;
	initWorker(&t);
	printWorkerInfo(t);
}
int main()
{
	//StuTest();
	//TecTest();
	WorkTest();
	return 1;
}
