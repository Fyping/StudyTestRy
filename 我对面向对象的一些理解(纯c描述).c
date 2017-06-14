#include<stdio.h>
#include<string.h>
/*�ô�Cд���Ҷ��������������,
��Ȼ��������̵�����,
������Ȼ��һ�����������ζ��*/
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
	char Scard[9];//ѧ��
	float avgScore;
	char major[30];
} Student;
typedef struct 
{
	Person worker;
	char Job[30];
	float salary;
	int Is_batch;//�Ƿ����
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
	printf("����%s\n�ҵ�������%d\n�ҵ��Ա�:%s\n",
		man.name,man.age,man.sex);
}
void initTeacher(Teacher *tech)
{
	strcpy(tech->teacher.name,"FangYanPing");
	tech->teacher.age=23;
	strcpy(tech->teacher.sex,"Boy");
	tech->salary=8000;
	strcpy(tech->Job,"��ѧ");
	strcpy(tech->subject,"Software");
}
void printTeacherInfo(Teacher tech)
{
	printPersonInfo(tech.teacher);
	printf("�ҵĹ�����%s\n",tech.Job);
	printf("�ҵ���н�����%f\n",tech.salary);
	printf("�����̵Ŀ�Ŀ��%s\n",tech.subject);
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
	printf("�ҵ�רҵ��%s\n",stu.major);
	printf("�ҵ�ѧ����%s\n",stu.Scard);
	printf("�ҵ�רҵ��ƽ���ɼ������%f\n",stu.avgScore);
}
void initWorker(Worker *work)
{
	strcpy(work->worker.name,"XiJP");
	work->worker.age=43;
	strcpy(work->worker.sex,"Male");
	work->salary=5000.00;
	strcpy(work->Job,"Building");
	work->Is_batch=1;//��ʼΪ�ѻ�
	work->HunLinOrDanShenC=5;
}
void printWorkerInfo(Worker work)
{
	printPersonInfo(work.worker);
	printf("�ҵĹ�����%s\n",work.Job);
	printf("�ҵ�һ���µĹ�����%f\n",work.salary);
	printf("�ҵĻ��������:");
	if(1==work.Is_batch)
	{printf("�ѻ�\n");
	printf("���Ѿ����%d����!\n",work.HunLinOrDanShenC);}
	else{printf("δ��,������\n");
	printf("���Ѿ�����%d����,���찡!����һ����Ե��!\n",work.HunLinOrDanShenC);}
}
void StuTest()//���в��Ժ���
{
	Student t;
	initStudent(&t);
	printStudentInfo(t);
}
void TecTest()//���в��Ժ���
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
